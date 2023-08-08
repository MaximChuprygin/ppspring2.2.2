package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model,/*HttpServletRequest request*/@RequestParam(value = "count" , required = false) String count) {
        //String count = request.getParameter("count");
        System.out.println("count = " + count);
        List<Car> cars = new ArrayList<>();
        if ( count == null || parseInt(count) < 1 || parseInt(count) > 4) {
            int a = 5;

            for (int i = 0 ; i < a; i++ ) {
                cars.add(new Car("1", 1, 1));
            }
        } else {
            for (int i = 0; i < parseInt(count); i++) {
                cars.add(new Car("1", 1, 1));
            }
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
