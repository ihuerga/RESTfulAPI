package org.reactome.restfulapi;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: home
 * Date: 6/15/11
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class RESTfulAPIResourceTest {
    // Two methods used in this class
    private final static String HTTP_GET = "Get";
    private final static String HTTP_POST = "Post";
    private final static String RESTFUL_URL = "http://www.reactome.org:8080/ReactomeRESTfulAPI/RESTfulWS/";
//    private final static String RESTFUL_URL = "http://reactomedev.oicr.on.ca:8080/ReactomeRESTfulAPI/RESTfulWS/";
//    private final static String RESTFUL_URL = "http://reactomedev.oicr.on.ca:7080/ReactomeRESTfulAPI/RESTfulWS/";
//    private final static String RESTFUL_URL = "http://localhost:8080/ReactomeRESTfulAPI/RESTfulWS/";
    
    @Test
    public void testBioPaxExporter() throws Exception {
        String url = RESTFUL_URL + "biopaxExporter/Level3/109581";
        System.out.println(url);
        String text = callHttp(url,
                HTTP_GET,
                "");
        System.out.println("Output from biopaxexporter (level2):\n");
        System.out.println(text);
        
//        url = RESTFUL_URL + "biopaxExporter/Level3/109581";
//        System.out.println(url);
//        text = callHttp(url,
//                HTTP_GET,
//                "");
//        System.out.println("\nOutput from biopaxexporter (level3):\n");
//        System.out.println(text);
    }
    
    @Test
    public void testSBMLExport() throws Exception {
        String url = RESTFUL_URL + "sbmlExporter/109581";
        System.out.println(url);
        String text = callHttp(url, HTTP_GET, "");
        System.out.println("Output from sbmlExporter:\n");
        System.out.println(text);
    }

    @Test
    public void testPathwayDiagram() throws Exception {
        String url = RESTFUL_URL + "pathwayDiagram/109581/png";
        String text = callHttp(url,
                HTTP_GET,
                "");
        System.out.println("Output from pathwaydiagram:\n");
        System.out.println(text);
        decodeInBase64(text, "69278.png");
        
        url = RESTFUL_URL + "pathwayDiagram/109581/pdf";
        text = callHttp(url,
                HTTP_GET,
                "");
        System.out.println("Output from pathwaydiagram:\n");
        System.out.println(text);
        decodeInBase64(text, "69278.pdf");
        // A disease diagram
        url = RESTFUL_URL + "pathwayDiagram/2206302/pdf";
        text = callHttp(url, HTTP_GET, "");
        decodeInBase64(text, "2206302.pdf");
    }
    
    public void decodeInBase64(String text, String fileName) throws IOException {
        byte[] content = Base64.decodeBase64(text);
        // Output the content into a local file
        FileOutputStream fos = new FileOutputStream(fileName);
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(content.length);
        byteBuffer.put(content);
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileChannel.close();
        fos.close();
    }
    
    /**
     * An example to query the FrontPage object and first FrontPmageItem.
     * @throws Exception
     */
//    @Test
//    public void testQueryFromPagePathways() throws Exception {
//        // The sole FrontPage item in realease 38
//        String url = RESTFUL_URL + "queryById/FrontPage/1591246";
//        String text = callHttp(url, HTTP_GET, "");
//        System.out.println("Front Page Instance:\n");
//        prettyPrintXML(text);
//        // Get the first FrontPageItem: Amyloids
//        // Process XML using JDOM
//        SAXBuilder builder = new SAXBuilder();
//        Document doc = builder.build(new StringReader(text));
//        Element first = doc.getRootElement().getChild("frontPageItem");
//        // Get the DB_ID
//        String firstDbId = first.getChildText("dbId");
//        url = RESTFUL_URL + "queryById/Event/" + firstDbId;
//        text = callHttp(url, HTTP_GET, "");
//        System.out.println("\nFirst Event in FrontPage:\n");
//        prettyPrintXML(text);
//    }
    
    @Test
    public void testQueryFrontPageItems() throws Exception  {
        String url = RESTFUL_URL + "frontPageItems";
        String text = callHttp(url, HTTP_GET, "");
        System.out.println("Front Page instances:\n");
        prettyPrintXML(text);
    }
    
    @Test
    public void testQueryAncestors() throws Exception {
        String url = RESTFUL_URL + "queryEventAncestors/69019";
        System.out.println(url);
        String text = callHttp(url, HTTP_GET, "");
        System.out.println("queryAncestors (4 branches for 69019): \n");
        prettyPrintXML(text);
    }

    @Test
    public void testQueryById() throws Exception {
        // Check a pathway instance
        String url = RESTFUL_URL + "queryById/Pathway/69278";
        String text = callHttp(url,
                HTTP_GET,
                "");
        System.out.println("Output from querybyid 69278:\n");
        prettyPrintXML(text);
        // Check for ReferenceGeneProduct
        url = RESTFUL_URL + "queryById/ReferenceGeneProduct/155554";
        text = callHttp(url, HTTP_GET, "");
        prettyPrintXML(text);
//        /// Another pathway
//        // Check a pathway instance
//        url = RESTFUL_URL + "querybyid/Pathway/198323";
//        text = callHttp(url,
//                HTTP_GET,
//                "");
//        System.out.println("Output from querybyid pathway 198323:\n");
//        prettyPrintXML(text);
//        // A reaction has hasMember value
//        url = RESTFUL_URL + "querybyid/Reaction/199299";
//        text = callHttp(url,
//                        HTTP_GET,
//                        "");
//        System.out.println("Output from querybyid reaction 199299:\n");
//        prettyPrintXML(text);
//        // Check a reaction instance
//        url = RESTFUL_URL + "querybyid/Person/69125";
//        text = callHttp(url, HTTP_GET, url);
//        System.out.println("Output from query reaction 69125:");
//        prettyPrintXML(text);
//        // Check another reaction
//        url = RESTFUL_URL + "querybyid/Reaction/451345";
//        text = callHttp(url, HTTP_GET, url);
//        System.out.println("Output from query reaction 451345:");
//        prettyPrintXML(text);
//        // Check a complex instance
//        url = RESTFUL_URL + "querybyid/Complex/446302";
//        text = callHttp(url, HTTP_GET, url);
//        System.out.println("Output from query complex 446302:");
//        prettyPrintXML(text);
//        // Check a LiteratureReference instance
//        url = RESTFUL_URL + "querybyid/LiteratureReference/69422";
//        text = callHttp(url, HTTP_GET, url);
//        System.out.println("Output from query reaction 69422:");
//        prettyPrintXML(text);
//        // Check a regulation instance
//        url = RESTFUL_URL + "querybyid/PositiveRegulation/111290";
//        text = callHttp(url, HTTP_GET, url);
//        System.out.println("Output from query positiveregulation 111290:");
//        prettyPrintXML(text);
//        //negative regulation instance
//        url = RESTFUL_URL + "querybyid/NegativeRegulation/500284";
//        text = callHttp(url, HTTP_GET, url);
//        System.out.println("Output from query negativeregulation 500284:");
//        prettyPrintXML(text);
//        
//        // Check based on stableId
        url = RESTFUL_URL + "queryById/Pathway/REACT_578";
        text = callHttp(url, HTTP_GET, url);
        System.out.println("Output from query pathway apoptosis REACT_578:");
        prettyPrintXML(text);
        
        url = RESTFUL_URL + "queryById/Reaction/REACT_21342";
        text = callHttp(url, HTTP_GET, url);
        System.out.println("Output from query reaction REACT_21342:");
        prettyPrintXML(text);
        
        // Check for a Summation
        url = RESTFUL_URL + "queryById/Summation/450983";
        text = callHttp(url, HTTP_GET, url);
        System.out.println("Output for query summation 450983:");
        prettyPrintXML(text);
        
        // Check for InstanceEdit
//        String url = RESTFUL_URL + "querybyid/InstanceEdit/168269";
//        String text = callHttp(url, HTTP_GET, url);
//        System.out.println("Output from query InstanceEdit 168267:");
//        prettyPrintXML(text);
                
    }

    @Test
    public void testQueryByIds() throws Exception {
        String url = RESTFUL_URL + "queryByIds/Pathway";
        String text = callHttp(url,
                HTTP_POST,
                "ID=109607,109606,75153,169911");
        System.out.println("Output from querybyids:\n");
        prettyPrintXML(text);
    }

    @Test
    public void testListByQuery() throws Exception {
        String url = RESTFUL_URL + "listByQuery/Pathway";
        String text = callHttp(url,
                HTTP_POST,
                "DB_ID=114298");
        System.out.println("Output from listByQuery for ID=114298:\n");
        prettyPrintXML(text);
        
        // Check a query based on name
        url = RESTFUL_URL + "listByQuery/Pathway";
        text = callHttp(url,
                HTTP_POST,
                "name=Apoptosis");
        System.out.println("Output from listByQuery for name=Apotosis:\n");
        prettyPrintXML(text);
    }

    @Test
    public void testListPathwayParticipants() throws Exception {
//        String url = RESTFUL_URL + "pathwayParticipants/75157";
        String url = RESTFUL_URL + "pathwayParticipants/109581";
        String text = callHttp(url,
                HTTP_GET,
                "");
        System.out.println("Output from pathwayParticipants:\n");
        prettyPrintXML(text);
    }
    
    @Test
    public void testTopLevelPathways() throws Exception {
        String url = RESTFUL_URL + "topLevelPathways";
        String text = callHttp(url, HTTP_GET, "");
        System.out.println("Output from topLevelPathways:\n");
        prettyPrintXML(text);
    }
    
    @Test
    public void testExportParticipatingMolecules() throws Exception {
        String url = RESTFUL_URL + "participatingMolecules/export/109581";
        String text = callHttp(url, HTTP_GET, "");
        System.out.println(text);
    }

//    @Test
//    public void testListTopLevelPathways() throws Exception {
//        String url = RESTFUL_URL + "toplevelpathways";
//        String text = callHttp(url,
//                HTTP_GET,
//                "");
//        System.out.println("Output from toplevelpathways:\n");
//        prettyPrintXML(text);
//    }

    @Test
    public void testQueryPathwaysforEntities() throws Exception {
        String url = RESTFUL_URL + "pathwaysForEntities";
//        String text = callHttp(url,
//                HTTP_POST,
//                "ID=114298"); 
//        System.out.println("Output from pathwaysforentities:\n");
//        prettyPrintXML(text);
        // CDC2 - 170075, HUS1 - 176374, MCM2 - 68557
        String text = callHttp(url,
                HTTP_POST,
                "ID=170075,176374,68557"); 
        System.out.println("Output from pathwaysforentities:\n");
        prettyPrintXML(text);
    }
    
    @Test
    public void testQueryReferences() throws Exception {
        String url = RESTFUL_URL + "queryReferences/140547";
        String text = callHttp(url, HTTP_GET, "");
        System.out.println("Output from queryReferences:\n");
        prettyPrintXML(text);
    }
    
    @Test
    public void testGetContainedEventIds() throws Exception {
        String url = RESTFUL_URL + "getContainedEventIds/109581";
        System.out.println(url);
        String text = callHttp(url, HTTP_GET, "");
        System.out.println("Contained Event DB_IDs for Apoptosis: " + text.length() + "\n");
        prettyPrintXML(text);
    }

    @Test
    public void testDoPathwayMapping() throws Exception {

    }

    @Test
    public void testDoPathwayEnrichmentAnalysis() throws Exception {
    }

    private void prettyPrintXML(String xml) throws JDOMException, IOException {
//        System.out.println(xml);
        // Check if it is an XML
        if (xml.startsWith("<?xml")) {
            SAXBuilder builder = new SAXBuilder();
            Reader reader = new StringReader(xml);
            Document doc = builder.build(reader);
            XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
            outputter.output(doc, System.out);
        }
        else {
            System.out.println(xml);
        }
    }

    private String callHttp(String url,
                            String type,
                            String query) throws IOException {
        HttpMethod method = null;
        HttpClient client = null;
        if (type.equals(HTTP_POST)) {
            method = new PostMethod(url);
            client = initializeHTTPClient((PostMethod) method, query);
        } else {
            method = new GetMethod(url); // Default
//            method.setRequestHeader("Accept", "text/plain, application/xml");
            method.setRequestHeader("Accept", "application/json");
            client = new HttpClient();
        }
        int responseCode = client.executeMethod(method);
        if (responseCode == HttpStatus.SC_OK) {
            InputStream is = method.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null)
                builder.append(line).append("\n");
            reader.close();
            isr.close();
            is.close();
            // Remove the last new line
            String rtn = builder.toString();
            // Just in case an empty string is returned
            if (rtn.length() == 0)
                return rtn;
            return rtn.substring(0, rtn.length() - 1);
        } else
            throw new IllegalStateException(method.getResponseBodyAsString());
    }

    private HttpClient initializeHTTPClient(PostMethod post, String query) throws UnsupportedEncodingException {
        RequestEntity entity = new StringRequestEntity(query, "text/plain", "UTF-8");
        post.setRequestEntity(entity);
        post.setRequestHeader("Accept", "application/XML, application/JSON, text/plain");
        //post.setRequestHeader("Accept", "application/json");
        HttpClient client = new HttpClient();
        return client;
    }
}