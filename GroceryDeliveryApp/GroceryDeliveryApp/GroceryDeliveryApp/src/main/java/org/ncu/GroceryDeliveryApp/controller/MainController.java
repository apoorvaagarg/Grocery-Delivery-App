package org.ncu.GroceryDeliveryApp.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.ncu.GroceryDeliveryApp.dao.AppDao;
import org.ncu.GroceryDeliveryApp.entity.Account;
import org.ncu.GroceryDeliveryApp.entity.Grocery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@ModelAttribute("account")
	public Account getAccount() {
	return new Account();
	}
	
	@Autowired
	private AppDao appDao;
	
	int min = 1;
    int max = 100;

	//---------------------------------------------------------------------
	//                                ADMIN
	//---------------------------------------------------------------------
	
	//================================ Admin login code ===========================
	
	
	@GetMapping("/adminLoginForm")
	public String adminloginForm(Model model)
	{
		return "adminLogin";
	}
	
	@PostMapping("/adminloginProcess")
	public String adminloginProcess(@RequestParam("username")String user, @RequestParam("password")String pass,
			Model model, HttpServletRequest request)
	{
		if (appDao.checkAdmin(user, pass))
		{
			String value = user;
			HttpSession session = request.getSession();
			session.setAttribute("seshID", value);
			return "redirect:/adminHomePage";
		}
		else
		{
			return "confirmation";
		}
	}
	
	
	//================================Admin Workspace code===========================
	
	//List display page to admin
	@GetMapping("/adminHomePage")
	public String adminPage(Model model)
	{
		List<Grocery> grocerylist = appDao.fetchAll();	
		model.addAttribute("groceries", grocerylist);
		return "adminHome";
	}
	
	//Update
	
	// item List to update form
	@GetMapping("/adminFormUpdate")
	public String showUpdateForm(@RequestParam("itemId")int ic, @ModelAttribute("grocery") Grocery saman,
			Model model)
	{
		//sending the book obj to view
		saman = appDao.getRecord(ic);
		model.addAttribute(saman);
		return "adminUpdateForm";
	}
	
	//update for to updated item list
	@PostMapping("/itemUpdateProcess")
	public String processUpdateForm(@ModelAttribute("grocery") Grocery saman) {
		
		appDao.updateRecord(saman);
		return "redirect:/adminHomePage";
	}
	
	//Delete
	
	@GetMapping("/adminDeleteItem")
	public String deleteForm(@RequestParam("itemId")int ic) {
		appDao.deleteRecord(ic);
		return "redirect:/adminHomePage";
	}
	
	//Insert Item
	
	@RequestMapping("/adminFormInsert")
	public String inputInsertItem()
	{
		return "adminInsertForm";
	}

	@RequestMapping("itemInsertProcess")
	public String insertProcessForm(@ModelAttribute("grocery")Grocery grocery, @RequestParam("itemCode") int code, @RequestParam("itemQuantity") int quantity, @RequestParam("itemPrice") float price, @RequestParam("itemDiscount") float discount, HttpServletRequest request) {
		
		String name = request.getParameter("itemName");
		
		Grocery gro = new Grocery();
		
		gro.setItemCode(code);
		gro.setItemName(name);
		gro.setItemPrice(price);
		gro.setItemQuantity(quantity);
		gro.setItemDiscount(discount);
	
		appDao.createRecord(gro);
		return "redirect:/adminHomePage";
	}
	
	//---------------------------------------------------------------------
	//                                BUYER
	//---------------------------------------------------------------------
		
	//================================Buyer login code===========================

	@GetMapping("/buyerLoginForm")
	public String buyerloginForm(Model model)
	{
		return "buyerLogin";
	}
	
	@PostMapping("/buyerloginProcess")
	public String buyerloginProcess(@RequestParam("username") String user, @RequestParam("password") String pass, 
			Model model,HttpServletRequest request, HttpServletResponse  response )
	{
		if(appDao.checkBuyer(user, pass))
		{
			Cookie ck = new Cookie("username", user);
			response.addCookie(ck);
			
			String value = user;
			HttpSession session = request.getSession();
			session.setAttribute("seshID", value);
			return "redirect:/buyerHomePage";
		}
		else
		{
			return "confirmation";
		}
	}
	
	//================================Buyer registration code===========================

	@GetMapping("/buyerRegistrationForm")
	public String buyerregForm()
	{
		return "buyerRegistration";
	}
	
	@PostMapping("/buyerRegistrationProcess")
	public String buyerregProcess(@Valid @ModelAttribute("account")Account account, BindingResult bindingResult,  
			HttpServletRequest request, Model model /* ,@RequestParam("userPhone") int phone */)
	{
		if(bindingResult.hasErrors())
		{
			return "buyerRegistration";
		}
		else
		{
			String user = account.getBuyerUser();
			String pass = account.getBuyerPass();
			String address = account.getBuyerAddress();
			String phone =account.getBuyerPhone();
			
			Account acc = new Account();
			
			acc.setBuyerUser(user);
			acc.setBuyerPass(pass);
			acc.setBuyerAddress(address);
			acc.setBuyerPhone(phone);
			
			if(appDao.createAccount(account)==1)
			{
				return "redirect:/buyerLoginForm";
			}
			else
			{
				return "redirect:/buyerRegistrationForm";
			}
			
		}
	}
	
	//================================Buyer profile update===========================
	
	//Update
	
		// item List to update form
		@RequestMapping("/buyerFormUpdate")
		public String buyerUpdateForm(Model model, HttpSession session)
		{
			String uname = (String) session.getAttribute("seshID");
			Account acc = appDao.getBuyerAccountInfo(uname);
			model.addAttribute("account", acc);
			return "buyerUpdateForm";
		}
		
		//update for to updated item list
		@PostMapping("/buyerUpdateProcess")
		public String buyerProcessUpdate(@ModelAttribute("account") Account acc) {
			appDao.updateAccount(acc);
			
			if (appDao.billIsEmpty())
				return "redirect:/buyerHomePage";
			else
				return "redirect:/buyerPayment";
		}
	
	//================================Buyer Shopping Space===========================
	
	//List display page to admin
	@RequestMapping("/buyerHomePage")
	public String buyerPage(Model model, HttpServletRequest request)
	{
		String orderby = request.getParameter("order");
		String item = request.getParameter("sitem");
		String comparisonasc = "asc";
		String comparisondesc = "desc";
		if(orderby!=null)
		{
			if(orderby.equals(comparisonasc))
			{
			List<Grocery> glist = appDao.orderbyASC();
			model.addAttribute("groceries", glist);
			}
			else if(orderby.equals(comparisondesc))
			{
			List<Grocery> glist = appDao.orderbyDESC();
			model.addAttribute("groceries", glist);
			} 	
		}
		else if(item!=null)
		{
			List<Grocery> grocerylist = appDao.searchItem(item);
			model.addAttribute("groceries", grocerylist);
		}
		else
		{
			List<Grocery> grocerylist = appDao.fetchAll();
			model.addAttribute("groceries", grocerylist);
		}
		List<Grocery> cartlist = appDao.fetchAllcItems();
		model.addAttribute("cItems",cartlist);
		return "buyerHome";
	}
	
	@GetMapping("/buyerAddtoCart")
	public String addToCart(@RequestParam("cItemId")int ci) {
		Grocery variable = appDao.selectCartItem(ci);
		int ran = (int)Math.floor(Math.random()*(max-min+1)+min);
		appDao.addCartItem(variable, ran);
		return "redirect:/buyerHomePage";
	}
	
	@GetMapping("/buyerDeletefromCart")
	public String deleteFromCart(@RequestParam("cItemInt") int r) {
		appDao.removeCartItem(r);
		return "redirect:/buyerHomePage";
	}
	
	//================================Final Billing===========================
	
	// Goes from Buyer main page to Bill Page
	@RequestMapping("checkOut")
	public String goToBill(Model model)
	{
		// For Bill Items
		List<Grocery> x = appDao.selectBillItems();	
		for(Grocery temp1 : x) {
			appDao.addToBillList(temp1);
		}
		List<Grocery> y = appDao.getFinalBill();	
		model.addAttribute("FinalBillItems", y);
		
		//For Billing Amount
		List<Grocery> a = appDao.selectBillPrice();	
		for(Grocery temp2 : a) {
			appDao.addToAmount(temp2);
		}
		List<Grocery> b = appDao.getBillAmount();	
		model.addAttribute("FinalBillAmount", b);
				
		return "billPage";
	}
	
	// terminate all temporary table data for the current buyer and log out
		@RequestMapping("buyerPayment")
		public String buyerPayment(Model model,Account currentBuyer, HttpSession session)
		{
			appDao.terminateCart();
			String uname = (String) session.getAttribute("seshID");
			List<Account> bi = appDao.getBuyerInfo(uname);	
			model.addAttribute("buyerInfo", bi);
			
			if(appDao.checkOffer())
			{
				return "specialThankYou";
			}
			else 
			{
				return "thankYou";	
			}
			
		}
	
	//================================Returning Buttons (LogOut?)===========================
	
	// Go back Buyer shop page from bill page to edit cart items
	@RequestMapping("backToShop")
	public String backToShop()
	{
		appDao.terminateBill();
		appDao.terminateAmount();
		return "redirect:/buyerHomePage";
	}
	
	@RequestMapping("logOut")
	public String logOut(HttpSession session)
	{
		appDao.terminateBill();
		appDao.terminateAmount();
		session.invalidate();
		return "home";
	}
	
	// Go back to index
	@RequestMapping("goBack")
	public String goToIndex()
	{
		return "home";
	}
	
}