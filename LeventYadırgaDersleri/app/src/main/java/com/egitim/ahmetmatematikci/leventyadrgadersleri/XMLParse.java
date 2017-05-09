package com.egitim.ahmetmatematikci.leventyadrgadersleri;

import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLParse extends AppCompatActivity {
    ListView lste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlparse);
        
        lste = (ListView)findViewById(R.id.listViewParse);
        
        WebServisIleListeyiDoldur();
    }

    private void WebServisIleListeyiDoldur() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String doviz_url = "http://www.tcmb.gov.tr/kurlar/today.xml";
        List<String>doviz_list = new ArrayList<String>();
        HttpURLConnection baglanti = null;

        try {
            URL url = new URL(doviz_url);
            baglanti = (HttpURLConnection)url.openConnection();
            int baglanti_durumu = baglanti.getResponseCode();

            if (baglanti_durumu == HttpURLConnection.HTTP_OK) {
                BufferedInputStream stream = new BufferedInputStream(baglanti.getInputStream());
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

                Document document = documentBuilder.parse(stream);

                NodeList dovizNodeList = document.getElementsByTagName("Currency");
                for (int i= 0; i<dovizNodeList.getLength(); i++) {
                    Element element = (Element)dovizNodeList.item(i);
                    NodeList nodeListBirim = element.getElementsByTagName("Unit");
                    NodeList nodeListParaBirim = element.getElementsByTagName("Isim");
                    NodeList nodeListAlis = element.getElementsByTagName("ForexBuying");
                    NodeList nodeListSatis = element.getElementsByTagName("ForexSelling");

                    String birim = nodeListBirim.item(0).getFirstChild().getNodeValue();
                    String parabirimi = nodeListParaBirim.item(0).getFirstChild().getNodeValue();
                    String alis = nodeListAlis.item(0).getFirstChild().getNodeValue();
                    String satis = nodeListSatis.item(0).getFirstChild().getNodeValue();

                    doviz_list.add(birim + " " + parabirimi + "Alış :  " + "Satış : " + satis);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baglanti != null)
                baglanti.disconnect();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, doviz_list);
        lste.setAdapter(adapter);



    }
}
