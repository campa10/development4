package web;

import Entities.Items;
import Entities.Login;
import Entities.Todo;
import Entities.UserSession;
import com.google.gson.Gson;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/login")
public class LoginController {

	Gson gson = null;
	String str = null;
	Object obj = null;
	Login login = null;
	Session session = null;
	UserSessionController userSessionController = null;

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(path = "/getall",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getAll(@RequestParam(name = "param1") String param1) {
		List itemList = new ArrayList<Object>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		{
			itemList = session.createQuery("from " + param1.replace("\"", "")).list();
			List<Object> entities = new ArrayList<>();
		}
		Items items = new Items();
		items.setItems(itemList);
		return new ResponseEntity<Object>(items, HttpStatus.OK);
	}


	/*http://localhost:8080/login/ngl?param1=ngl
	{"userName": "user1", "password": "pass1", "loginId": 2}*/
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/ngl", method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody Object object, @RequestParam(name = "param1") String param1) {

		session = HibernateUtil.getSessionFactory().openSession();
		gson = new Gson();
		str = gson.toJson(object);
		obj = new Object();

		switch (param1) {

			case "ngl":
				login = gson.fromJson(str, Login.class);
				userSessionController = new UserSessionController();
				obj = login;
				if(authenticateUser(login)){
					userSessionController.newSession(login);
				}
				obj = userSessionController;
				obj = userSessionController.newSession(login);
		}
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

	//business logic
	private boolean authenticateUser(Login login){
		return true;
	}


}