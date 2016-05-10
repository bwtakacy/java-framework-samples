package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import views.html.*;
import play.data.validation.Constraints.*;


public class HomeController extends Controller {

    public static class MyForm {
        @Required
        public String name;
        public String mail;
        public String tel;

        public String toString() {
            return "NAME:" + name + " MAIL:" + mail + " TEL:" + tel;
        }
    }

    public Result index() {
        String title = "Play Sample Page";
        String msg = "フォームのサンプルです。";
        return ok(index.render(title, msg, form(MyForm.class)));
    }

    public Result sendform() {
        String title = "Play Send Form Page";
        Form<MyForm> form = form(MyForm.class).bindFromRequest();
        if (form.hasErrors()) {
            String msg = "入力に問題があります。";
            return badRequest(index.render(title, msg, form));
        } else {
            MyForm data = form.get();
            String msg = data.toString();
            return ok(index.render(title, msg, form));
        }
    }

}
