package StudentResultManagement.Model;

public class Result {
	private String rollNo;
    private String Java;  
   private String DataStructure; 
   private String Webprogram ;
   private String ComputerNetwork;
    private String OperatingSystem;
   

	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getJava() {
		return Java;
	}
	public void setJava(String java) {
		Java = java;
	}
	public String getDataStructure() {
		return DataStructure;
	}
	public void setDataStructure(String dataStructure) {
		DataStructure = dataStructure;
	}
	public String getWebprogram() {
		return Webprogram;
	}
	public void setWebprogram(String webprogram) {
		Webprogram = webprogram;
	}
	public String getComputerNetwork() {
		return ComputerNetwork;
	}
	public void setComputerNetwork(String computerNetwork) {
		ComputerNetwork = computerNetwork;
	}
	public String getOperatingSystem() {
		return OperatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		OperatingSystem = operatingSystem;
	}
	public Result() {
		super();
	}
	
	public Result(String rollNo, String java, String dataStructure, String webprogram, String computerNetwork,
			String operatingSystem) {
		super();
		this.rollNo = rollNo;
		Java = java;
		DataStructure = dataStructure;
		Webprogram = webprogram;
		ComputerNetwork = computerNetwork;
		OperatingSystem = operatingSystem;
		}
	   
	
}
