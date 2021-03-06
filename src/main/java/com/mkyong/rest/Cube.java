package com.mkyong.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/cube")
public class Cube {
	@GET
	@Path("/{param0}/{param1}")
	@Produces(MediaType.APPLICATION_JSON)
	public CubeVO getMsg(@PathParam("param0") String msg, @PathParam ("param1")String msg1) {

		int a = Integer.parseInt(msg);
		int b =Integer.parseInt(msg1);
		return calculateCube(a,b);

	}
	private CubeVO calculateCube(int a,int b){
		CubeVO data=new CubeVO();
		int c,d;


		c=(a+b);
		d=c*c*c;
		String e =Integer.toString(d);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		String output ="(a+b)^3=" +d;
		data.setA(a);
		data.setB(b);
		data.setC(c);
		data.setD(d);



		return data;

	}
}
