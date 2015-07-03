package com.iotNM.tests;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.iotNM.entity.xml.IOT_DIR;
import com.iotNM.entity.xml.NETS;

public class testXML2Bean {
	public static void XMLStringToBean(){  
        String xmlStr = "<?xml version=\"1.0\" encoding=\"GB2312\"?><IOT_DIR packageName=\"DIRS\" appID=\"49\" timeStamp=\"20150510\" packageSize=\"52728\"><PARAMETER startLevel=\"2\" endLevel=\"6\" netID=\"-1\" subNetID=\"-1\" nodeID=\"-1\" sensorID=\"-1\"/><NETS><NETSIZE>23</NETSIZE><NET><NTID>2</NTID><NTDSCRPT>1</NTDSCRPT><SUBNETSIZE>2</SUBNETSIZE><SUBNET><SBNTID>1</SBNTID><NTNM>1号</NTNM><DSPT>123</DSPT><NODESIZE>1</NODESIZE><NODE><NDPHDR>123</NDPHDR><NDDSPT>123</NDDSPT><TRSMTPWR>123123</TRSMTPWR><SENSORSIZE>1</SENSORSIZE><SENSOR><SNSR_TP>1</SNSR_TP><STPNM>温度</STPNM><DSPTN>1</DSPTN><UNIT>40</UNIT></SENSOR></NODE></SUBNET><SUBNET><SBNTID>2</SBNTID><NTNM>3</NTNM><DSPT>4</DSPT><NODESIZE>1</NODESIZE><NODE><NDPHDR>7</NDPHDR><NDDSPT>6</NDDSPT><TRSMTPWR>3</TRSMTPWR></NODE></SUBNET></NET><NET><NTID>6</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>7</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>4</NTID><NTDSCRPT>3</NTDSCRPT><SUBNETSIZE>1</SUBNETSIZE><SUBNET><SBNTID>2</SBNTID><NTNM>3</NTNM><DSPT>4</DSPT></SUBNET></NET><NET><NTID>9</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>10</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>5</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>12</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>13</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>8</NTID><NTDSCRPT>3</NTDSCRPT><SUBNETSIZE>1</SUBNETSIZE><SUBNET><SBNTID>1</SBNTID><NTNM>aaaa</NTNM><DSPT>?°????è??é??</DSPT><NODESIZE>1</NODESIZE><NODE><NDPHDR>7</NDPHDR><NDDSPT>6</NDDSPT><TRSMTPWR>3</TRSMTPWR></NODE></SUBNET></NET><NET><NTID>15</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>16</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>11</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>18</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>19</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>14</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>21</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>22</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>17</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>24</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>25</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>20</NTID><NTDSCRPT>3</NTDSCRPT></NET><NET><NTID>23</NTID><NTDSCRPT>3</NTDSCRPT></NET></NETS></IOT_DIR>";  
        try {  
            JAXBContext context = JAXBContext.newInstance(IOT_DIR.class);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            IOT_DIR iot = (IOT_DIR)unmarshaller.unmarshal(new StringReader(xmlStr));  
            System.out.println(iot.getNETS().getNET().get(0).getSUBNET().get(0).getNODE().get(0).getSENSOR().get(0).getSTPNM());  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
          
    }
	public static void main(String[] args) {
		XMLStringToBean();
	}
}
