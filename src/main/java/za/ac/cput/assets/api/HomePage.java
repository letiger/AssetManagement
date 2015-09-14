package za.ac.cput.assets.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by student on 2015/08/11.
 */
@RestController
@RequestMapping("/**")
public class HomePage {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String Index(){
        return "Asset Management is live...";
    }
}
