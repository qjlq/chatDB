package boot.spring.controller;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import boot.spring.po.*;
import boot.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {
	@Resource
	ProductService productService;

	@Resource
	MessageService messageService;

	@Resource
	HistoryMessageService historyMessageService;

	@Resource
	LoginService loginService;

	@Resource
	OrderService orderService;

	@Resource
	EmpService empService;
	/**
	 * 在线用户
	 */
	//加载当前用户
	@RequestMapping("/onlineusers")
	@ResponseBody
	public Set<String> onlineusers(@RequestParam("currentuser") String currentuser) {
		ConcurrentHashMap<String, Session> map = WebSocketServer.getSessionPools();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		Set<String> nameset = new HashSet<String>();
		while (it.hasNext()) {
			String entry = it.next();
			if (!entry.equals(currentuser))
				nameset.add(entry);
		}
		return nameset;
	}
	
	/**
	 * 当前用户
	 */
	@RequestMapping(value = "/currentuser", method = RequestMethod.GET)
	@ResponseBody
	public User currentuser(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		return user;
	}

	@RequestMapping("/storemessage")
	@ResponseBody
	public SaveMessage storemessage(@RequestParam("uid") String uid,
							 @RequestParam("text") String text,
							 @RequestParam("time") String time) {
		String cid = UUID.randomUUID().toString();
		SaveMessage message = new SaveMessage(cid, uid, text, time);
		System.out.println(message.toString());
		messageService.saveMessage(message);
		return message;
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "login";
	}

	@RequestMapping("/history")
	public String history() {
		return "order";
	}

	@RequestMapping("/profile")
	public String profile(){
		return "profile";
	}

	@RequestMapping("/OutputChat")
	public String OutputChat(){
		return "Outputchat";
	}

	@RequestMapping("/findHistoryMessage")
	@ResponseBody
	public List<HistoryMessage> findHistoryMessage(Model m) {
		List<HistoryMessage> historyMessages = historyMessageService.getHistoryMessage();
//        System.out.println("sss:"+outputChats);
		return historyMessages;
	}

	@RequestMapping("/buyProduct")
	@ResponseBody
	public String buyProduct(@RequestParam("pid") String pid,
							 @RequestParam("quantity") int quantity,
							 @RequestParam("buy_id") String buy_id) {
		Product product = productService.getProductByPid(pid);
		User buyer = loginService.getUserByUid(buy_id);
		User seller = loginService.getUserByPid(pid);
		BigDecimal total = product.price.multiply(new BigDecimal(quantity));
		if (buyer.getMoney().compareTo(total) < 0){
			return "nomoney";
		}
		else if (product.quantity < quantity ){
			return "noquantity";
		}
		else {
			seller.setMoney(buyer.getMoney().add(total));
			buyer.setMoney(buyer.getMoney().subtract(total));
			empService.update(seller);
			empService.update(buyer);
			product.quantity -= quantity;
			productService.updateQuantity(product);
			String oid = UUID.randomUUID().toString();
			String lnumber = UUID.randomUUID().toString();
			String otime = (new Date()).toString();
			Order order = new Order(oid,product.lid, buy_id, quantity, total, otime, "unsent",lnumber,product.product_name, product.picture);
			orderService.addOrder(order);
		}
		return "success";
	}
}
