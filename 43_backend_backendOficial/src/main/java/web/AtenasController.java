package web;

import Entities.*;
import com.google.gson.Gson;

import net.minidev.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import util.HibernateUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.*;


@Controller
@RequestMapping("/atenas")
public class AtenasController {

	private UUID uuid = null;
	private static final Logger log = LogManager.getLogger();
	//Endpoint: send email


	public static void send(final String from, final String password, String to, String sub, String msg) {
		//Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		//get Session
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, password);
					}
				});
		//compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			//send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}


	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAll(@RequestParam(name = "param1") String param1) {

		//EMAIL SEND
		//send("hernan.bogantes@gmail.com", "Afrodit@09.", "hernan.bogantes@gmail.com", "hello javatpoint", "How r u?");
		//busqueda varias palabras separadas por espacio
		//generar parametros dinamicamente
		// createQuery("from " + param1.replace("\"", "") +  " where username = :tid" + " and password = :tid2 ").
		List itemList = new ArrayList<Object>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		itemList = session.createQuery("from " + param1.replace("\"", "")).list();
		List<Object> entities = new ArrayList<>();
		Items items = new Items();
		items.setItems(itemList);
		return new ResponseEntity<Object>(items, HttpStatus.OK);
	}



	@RequestMapping(value = "/validate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Boolean validate(@RequestParam(name = "param1") String param1,@RequestParam(name = "param2") String param2 ) {
		boolean value = false;
		if(param2.equalsIgnoreCase("user1")){
			value = true;
		}
		else {
			value = false;
		}
		return value;

	}


	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(path = "/findby", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findBy(@RequestParam(name = "param1") String param1,@RequestParam(name = "param2") String param2 ) {

		Object itemList = new Object();
		Session session = HibernateUtil.getSessionFactory().openSession();
		itemList = session.createQuery("from " + param1.replace("\"", "") +  " where username = :tid").
				setParameter("tid", param2).list();
		//List<Object> entities = new ArrayList<>();
		return new ResponseEntity<Object>(itemList, HttpStatus.OK);
	}





	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody Object object, @RequestParam(name = "param1") String param1, @RequestParam(name = "param2") String param2, @RequestParam(name = "param3") String param3
	) throws Exception {
		List itemList = new ArrayList<Object>();
		Session session = HibernateUtil.getSessionFactory().openSession();

		itemList = session.createQuery("from " + param1.replace("\"", "") +  " where username = :tid" + " and password = :tid2 ").
				setParameter("tid", param2).
				setParameter("tid2", param3).list();

		List<Object> entities = new ArrayList<>();
		Object login = new Login();
		((Login) itemList.get(0)).setPassword("aS65A4A#%!$&/%6SD4A6-45A64S#");
		((Login) itemList.get(0)).setLoginId((long) 341234);


		Items items = new Items();
		items.setItems(itemList);
		return new ResponseEntity<Object>(items, HttpStatus.OK);

	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addupdate(@RequestBody Object object, @RequestParam(name = "param1") String param1) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Gson gson = new Gson();
		String str = gson.toJson(object);
		Object obj = null;
		switch (param1) {

			case "Login":
				Login login = null;
				login = gson.fromJson(str, Login.class);
				obj = login;
				session.beginTransaction();
				session.saveOrUpdate(obj);
				session.getTransaction().commit();
				break;

			case "Persona":
				Persona persona = null;
				persona = gson.fromJson(str, Persona.class);
				obj = persona;
				session.beginTransaction();
				session.saveOrUpdate(obj);
				session.getTransaction().commit();
				break;
			case "Todo":
				Todo todo = null;
				todo = gson.fromJson(str, Todo.class);
				obj = todo;
				session.beginTransaction();
				session.saveOrUpdate(obj);
				session.getTransaction().commit();
				break;

			case "Wishlist":
				Wishlist wishlist = null;
				wishlist = gson.fromJson(str, Wishlist.class);
				obj = wishlist;
				session.beginTransaction();
				session.saveOrUpdate(obj);
				session.getTransaction().commit();
				break;

			case "drp":
				Producto producto = null;
				producto = gson.fromJson(str, Producto.class);
				obj = producto;
				session.beginTransaction();
				session.saveOrUpdate(obj);
				session.getTransaction().commit();
				break;

			case "ListaCompra":
				ListaCompra listaCompra = null;
				listaCompra = gson.fromJson(str, ListaCompra.class);
				obj = listaCompra;
				session.beginTransaction();
				session.saveOrUpdate(obj);
				session.getTransaction().commit();
				break;
			case "ListaCompraTotals":
				try {
					ListaCompraTotals listaCompraTotals = null;
					listaCompraTotals = gson.fromJson(str, ListaCompraTotals.class);
					obj = listaCompraTotals;
					Query query = session.createSQLQuery("select Insert_into_table(:tcatagory)").setParameter("tcatagory", 5);
					query.executeUpdate();
					//List<Ticket> ert = session.NamedStoredProcedureQuery("secondProcedure").setParameter("cnt", listaCompraTotals.getTotalprecioventa()).getResultList();
				} catch (Exception dd) {
					String sss = dd.getMessage();
				}
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + param1);
		}
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@RequestParam(name = "todoId") int todoId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(todoId);

		Todo todo = new Todo();
		todo.setTodoid(todoId);
		session.delete(todo);
		session.getTransaction().commit();

		return new ResponseEntity<Object>(todo, HttpStatus.OK);
	}

	/*usar segun
	https://spring.io/guides/gs/serving-web-content/
	http://localhost:8080/atenas/intro
	http://localhost:8080/atenas/intro?name=HERNAN BOGANTES
	http://localhost:8080/greeting?name=User.
	*/
	@GetMapping("/intro")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	//convert to base64
	public void addImage() {
		File dir = new File("/home/user1/Pictures/movies/");
		//uuid = UUID.randomUUID();
		//FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Todo todo = null;
		if (dir.isDirectory()) {
			for (final File f : dir.listFiles()) {

				//fis = new FileInputStream(f);
				bos = new ByteArrayOutputStream();
				todo = new Todo();
				byte[] buf = new byte[1000000024];
				//for (int readNum; (readNum = fis.read(buf)) != -1; ) {bos.write(buf, 0, readNum);}
				todo.setTitulo(f.getName());
				todo.setFoto1(f.getPath());
				todo.setPersonaid(1);
				todo.setActivo(false);
				session.beginTransaction();
				session.save(todo);
				session.getTransaction().commit();
			}
		}
	}

	private static String encode(byte[] bytes) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
	}

	private String hmacSha256(String data, String secret) throws Exception {
		//MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = secret.getBytes(StandardCharsets.UTF_8);//digest.digest(secret.getBytes(StandardCharsets.UTF_8));

		Mac sha256Hmac = Mac.getInstance("HmacSHA256");
		SecretKeySpec secretKey = new SecretKeySpec(hash, "HmacSHA256");
		sha256Hmac.init(secretKey);

		byte[] signedBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));

		return encode(signedBytes);
	}

	private String base64(String input) throws Exception {
		return encode(input.getBytes("utf-8"));
	}

	//genera el jwt token
	public void should_generate_jwt() throws Exception {

		String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";

		JSONObject payload = new JSONObject();
		payload.put("sub", "sub123");
		payload.put("aud", "aud123");
		payload.put("exp", 3600);

		String secret = "yo soy de alajuela";

		String signature = hmacSha256(base64(header) + "." + base64(payload.toJSONString()), secret);
		String jwtToken = base64(header) + "." + base64(payload.toJSONString()) + "." + signature;

		log.info("Here is my jwt " + jwtToken);
	}

	//metodo para agregar persona que de una agrega en login ....



}