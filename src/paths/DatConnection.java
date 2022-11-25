package paths;

public class DatConnection {
	String datFile = "C:\\Users\\aseba\\Documents\\Eva1Proyect\\proyect_files\\01102022.dat";
	
	public DatConnection() {}
	
	public DatConnection(String conta) {
		this.datFile = conta;
	}
	public String getDatFile() {
		return datFile;
	}
	public void setDatFile(String contaFile) {
		this.datFile = contaFile;
	}
	@Override
	public String toString() {
		return "FlConnection [contaFile=" + datFile + "]";
	}
	
}
