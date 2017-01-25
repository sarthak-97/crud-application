package crud.app.controller;

import java.util.Map;


import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import crud.app.models.studentmodel;

@Controller
public class controll {
	@Autowired
	private SessionFactory sessionFactory;
	studentmodel user;
     
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView adds(HttpSession httpSession, @RequestParam Map<String,String> requestParams) {
		
		
				String name = requestParams.get("name");
		String age = requestParams.get("age");
		String clgname = requestParams.get("clg");
				String address = requestParams.get("address");
		 Session session =	sessionFactory.openSession();
	       session.beginTransaction();
	       
	      ModelAndView model = new ModelAndView("add");
	         
	       Query queryResult = session.createQuery("from studentmodel");
	       java.util.List allUsers;
	       String nam,ages;
	       
	       allUsers = queryResult.list();
	       int f;
	       f=0;
	       for (int i = 0; i < allUsers.size(); i++) {
	    	   studentmodel user = (studentmodel) allUsers.get(i);
	        nam=user.getName();
	        ages=user.getAge();
		      
	        if(name.equals(nam) & age.equals(ages)){
	         f=1;
	     
	        break; 
	   
	        
	         }
	        }
	         
	           if(f!=1){
	        	   studentmodel user= new studentmodel();  
	      
	     user.setName(name);
	     user.setAge(age);
	     user.setAddress(address);
	    user.setClg(clgname);
	      session.save(user);
	       session.getTransaction().commit();
	   
	       session.close(); 
	       user=null;
	       System.out.println(clgname);
	       model.addObject("add","record added");
	      
	     

	           } 
	           else
	           {   System.out.println("duplicate");
	           model.addObject("dup","duplicate record"); 
	           }
	           return model;  
		}	   
	
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public ModelAndView del(HttpSession httpSession, @RequestParam Map<String,String> requestParams) {
		
		
				String studentId = requestParams.get("name");
		String age = requestParams.get("age");
		String clgname = requestParams.get("clgname");
				String address = requestParams.get("address");
		 Session session =	sessionFactory.openSession();
	       session.beginTransaction();
	       
	      ModelAndView model = new ModelAndView("del");
	         
	       Query queryResult = session.createQuery("from studentmodel");
	       java.util.List allUsers;
	       String nam,ages;
	     
	       allUsers = queryResult.list();
	       int f;
	       f=0;
	       for (int i = 0; i < allUsers.size(); i++) {
	    	   studentmodel user = (studentmodel) allUsers.get(i);
	        nam=user.getName();
	        ages=user.getAge();
		
	        if( age.equals(ages)){
	         f=1;
	     
	        break; 
	   
	        
	         }
	        }
	         
	           if(f==1){
	        studentmodel user= (studentmodel) session.get(studentmodel.class,studentId);
	      
	     
	      session.delete(user);
	       session.getTransaction().commit();
	   
	       session.close(); 
	       user=null;
	       System.out.println(studentId);
	       model.addObject("delete","deleted");
	      
	     

	           } 
	           else
	           {   System.out.println("not found");
	           model.addObject("nr","not found "); 
	           }
	           return model;  
		}	   
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public ModelAndView edit(HttpSession httpSession, @RequestParam Map<String,String> requestParams) {
		
		
				String studentId = requestParams.get("id");
	
		 Session session =	sessionFactory.openSession();
	       session.beginTransaction();
	       
	      ModelAndView model = new ModelAndView("edit");
	         
	       Query queryResult = session.createQuery("from studentmodel");
	       java.util.List allUsers;
	       String stid,name,clg,age,address;
	       stid=null;
	       name=null;
	       clg=null;
	       address=null;
	       age=null;
	       allUsers = queryResult.list();
	       int f;
	       f=0;
	       for (int i = 0; i < allUsers.size(); i++) {
	    	   studentmodel user = (studentmodel) allUsers.get(i);
	         stid=user.getStudentId();
	         name=user.getName();
	         clg=user.getClg();
	         age=user.getAge();
	         address=user.getAddress();
	         if(studentId.equals(stid) ){
		         f=1;
		         break;
	        
	        }
	         	         
	       }
	       if(f==1){
		         model.addObject("studid",stid); 
		         model.addObject("name",name); 
		         model.addObject("age",age); 
		         model.addObject("clg",clg); 
		         model.addObject("address",address); 
	        
	        }
	         else
	         {
	        	  model.addObject("norec","no record found");  
	         }
	         
	       return model;
	}
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(HttpSession httpSession, @RequestParam Map<String,String> requestParams) {
	    ModelAndView model = new ModelAndView("edit");
		String studentId = requestParams.get("id");
				String name = requestParams.get("name");
		String age = requestParams.get("age");
		String clgname = requestParams.get("clg");
				String address = requestParams.get("address");
		 Session session =	sessionFactory.openSession();
	       session.beginTransaction();
	       
	  
	       studentmodel user= (studentmodel) session.get(studentmodel.class,studentId);
	       user.setName(name);
	       user.setClg(clgname);
	       user.setAge(age);
	       user.setAddress(address);
	       
		      session.update(user);
		       session.getTransaction().commit();
		   
		       session.close(); 
		       model.addObject("rec","record edited");
		       return model;
	}

}
	
