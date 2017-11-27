package Invent;

import java.util.List;
import java.util.Map;

public class InventItem {

    // fields declarations

    private String pcName;
    private String osName;
    private String osSP;
    //   private String cpuName;
    private String ramSize;
    //   private String hddName;
    private String lanIP;
    private List<String> printList;
    private Map<String, String> licList;

    // getters-setters declaration

    public String getPcName() {
        return pcName;
    }

    public String getOsName() {
        return osName;
    }

    public String getOsSP() {
        return osSP;
    }

//    public String getCpuName() {
//        return cpuName;
//    }

    public String getRamSize() {
        return ramSize;
    }

//    public String getHddName() {
//        return hddName;
//    }

    public String getLanIP() {
        return lanIP;
    }

    public List<String> getPrintList() {
        return printList;
    }

    public Map<String, String> getLicList() {
        return licList;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public void setOsSP(String osSP) {
        this.osSP = osSP;
    }

//    public void setCpuName(String cpuName) {
//        this.cpuName = cpuName;
//    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

//    public void setHddName(String hddName) {
//        this.hddName = hddName;
//    }

    public void setLanIP(String lanIP) {
        this.lanIP = lanIP;
    }

    public void setPrintList(List<String> printList) {
        this.printList = printList;
    }

    public void setLicList(Map<String, String> licList) {
        this.licList = licList;
    }

}
