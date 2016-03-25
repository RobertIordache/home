package ro.robert.RESTfull.UploadImage;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


@Path("res")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Robert did it and works! :)";
    }
    
    @GET
    @Path("/images/{name}")
    @Produces("image/jpg")
    public Response downloadImageFile(@PathParam("name")String denumire) {
    	ClassLoader classLoader = getClass().getClassLoader();
        // set file (and path) to be download
    	String path=null;
    	try{
    		 path=classLoader.getResource("im ages/"+denumire).getFile();
    		 path=URLDecoder.decode(path,"UTF-8");
    	}catch(NullPointerException ex){
    		System.out.println(ex.getMessage());
    		 return Response.ok().status(404).build();
    	} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(path);
        File file = new File(path);
 
        ResponseBuilder responseBuilder = Response.ok((Object) file);
       // responseBuilder.header("Content-Disposition", "attachment; filename=\"MyPngImageFile.png\"");
        return responseBuilder.build();
    }
    
    
}
