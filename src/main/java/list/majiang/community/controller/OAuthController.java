package list.majiang.community.controller;

import list.majiang.community.dto.AccessTokenDTO;
import list.majiang.community.dto.GithubUser;
import list.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OAuthController {
    @Autowired
    GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                            @RequestParam("state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("d7d67b10085a770be356");
        accessTokenDTO.setClient_secret("5ba0653aaf4264d37621ff8835378433ff456642");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);

        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());

        return "index";
    }
}
