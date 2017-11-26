
public class Violation {

	private String studentID;
	private String secturiyID;
	private Location location;
	private ViolationType type;
	private String proof;
	private String proofIMG; /*
							  * // encode base64 from image
							  * ByteArrayOutputStream baos = new ByteArrayOutputStream();
							  * imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
							  * byte[] b = baos.toByteArray();
							  * encodedString = Base64.encodeToString(b, Base64.URL_SAFE | Base64.NO_WRAP);
							  * 
							  * */
								
	private int timestamp;
	
	
	
	
	
	
}
