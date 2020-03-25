package by.htp.library.start;

import by.htp.library.bean.User;
import by.htp.library.controller.Controller;


public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();

		String request, response;

		//request = "REGISTRATION login=ttt password=iii name=anna surname=zuk";
		//request = "authorization login=qqq password=www";
		//request = "add_new_book author='Грин' title='С++' publishingHouse='Питер' yearPublished=2019 pageCount=720 status='digit'";
		//request = "edit_book id=2 author='Хорстманн' title='JAVA' publishingHouse='Вильямс' yearPublished=2020 pageCount=576 status='digit'";
		request = "change_user_status id=5 role=admin";
		response = controller.action(request);

		System.out.println(response);
		
		

	}

}
