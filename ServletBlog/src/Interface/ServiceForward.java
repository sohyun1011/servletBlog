package Interface;

public class ServiceForward {
	
	private String path; //이동할 주소
	private boolean isRedirect; //리다이렉트 여부 (true = redirect / false = forward)
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	

}
