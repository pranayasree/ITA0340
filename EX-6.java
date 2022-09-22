
MAIN ACTIVITY.JAVA

Package com.example.ex.no6;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity
{
EditText et1;
Button b;
TextView tv;
NodeList children;
aravindonlineclasses.com
@Override
protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
super.onCreate(savedInstanceState);
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
et1 = (EditText) findViewById(R.id.editText1);
b= (Button) findViewById(R.id.button1);
tv = (TextView) findViewById(R.id.textView3);
String xml = ParseXMLMethods.getXML();
Document doc = ParseXMLMethods.XMLfromString(xml);
children = doc.getElementsByTagName("city");
b.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View arg0) {
// TODO Auto-generated method stub
String city = et1.getText().toString();
for (int i = 0; i < children.getLength(); i++) {
Element e = (Element) children.item(i);
String id = ParseXMLMethods.getValue(e, "id");
String name = ParseXMLMethods.getValue(e, 
"name");
if(name.equals(city))
{
tv.setText(id+ " Celsius");
}
}
}
});
}
}

PHRASE XML METHODS .JAVA

package com.example.ex.no6;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
aravindonlineclasses.com
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public class ParseXMLMethods {
public final static Document XMLfromString(String xml){
Document doc = null;
DocumentBuilderFactory dbf = 
DocumentBuilderFactory.newInstance();
 try {
 
DocumentBuilder db = dbf.newDocumentBuilder();
InputSource is = new InputSource();
 is.setCharacterStream(new StringReader(xml));
 doc = db.parse(is); 
 
} catch (Exception e){}
 return doc;
}
public final static String getElementValue( Node elem ) {
 Node kid;
 if( elem != null){
 if (elem.hasChildNodes()){
 for( kid = elem.getFirstChild(); kid != null; kid = 
kid.getNextSibling() ){
 if( kid.getNodeType() == Node.TEXT_NODE ){
 return kid.getNodeValue();
 }
 }
 }
 }
 return "";
}
public static String getXML(){
String line = null;
try {
DefaultHttpClient httpClient = new 
DefaultHttpClient();
HttpPost httpPost = new 
HttpPost("http://aravindonlineclasses.com/madlab/Rss.xml");
HttpResponse httpResponse = 
httpClient.execute(httpPost);
HttpEntity httpEntity = httpResponse.getEntity();
line = EntityUtils.toString(httpEntity);
} catch (Exception e) {
line = "Internet Connection Error >> " + 
aravindonlineclasses.com
e.getMessage();
} 
return line;
}
public static int numResults(Document doc){
Node results = doc.getDocumentElement();
int res = -1;
try{
res = 
Integer.valueOf(results.getAttributes().getNamedItem("count").getNodeValue())
;
}catch(Exception e ){
res = -1;
}
return res;
}
public static String getValue(Element item, String str) {
NodeList n = item.getElementsByTagName(str);
return ParseXMLMethods.getElementValue(n.item(0));
}
}