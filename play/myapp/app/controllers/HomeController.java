package controllers;

import java.util.*;

import com.avaje.ebean.*;
import models.*;
import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import views.html.*;


public class HomeController extends Controller {


    public Result index() {
        String title = "Play Sample Page";
        String msg = "フォームのサンプルです。";
        Form<MyData> mydata = form(MyData.class);
        List<MyData> mydatas = MyData.find.all();
        return ok(index.render(title, msg, mydatas, mydata));
    }

    public Result add() {
        Form<MyData> mydata = form(MyData.class).bindFromRequest();
        if (!mydata.hasErrors()) {
            mydata.get().save();
            flash();
        }
        return redirect(routes.HomeController.index());
    }

    public Result show(Long id) {
        String title = "Play Find Page";
        String msg = "ID=" + id + "の情報";
        MyData mydata = MyData.find.byId(id);
        return ok(show.render(title, msg, id, mydata));
    }

    public Result edit(Long id) {
        String title = "Play Find Page";
        String msg = "ID=" + id + "の編集";
        MyData data = MyData.find.byId(id);
        Form<MyData> mydata = form(MyData.class).fill(data);
        return ok(edit.render(title, msg, id, mydata));
    }

    public Result update(Long id) {
        Form<MyData> mydata = form(MyData.class).bindFromRequest();
        if (!mydata.hasErrors()) {
            mydata.get().update(id.toString());
            flash();
        }
        return redirect(routes.HomeController.index());
    }
}
