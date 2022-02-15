package com.board.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.Member;
import com.board.naver.NaverLoginBO;
import com.board.service.MemberService;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.protobuf.TextFormat.ParseException;


@Controller // 컨트롤러 빈으로 등록 
@RequestMapping("/board/")
@SessionAttributes("login")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;


	
	
	
	@RequestMapping("login")
	public String login() {
		return "board/login";
	}
	
	//로그인 처리
		@RequestMapping(value="/loginCheck")
		public ModelAndView loginCheck(@ModelAttribute Member vo,HttpSession session) {
			
			boolean result = memberService.loginCheck(vo, session); //id ,pwd 잘 넘어옴
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("board/login");
			
			if(result) {
				mav.addObject("msg","성공");
			}else {
				mav.addObject("msg","실패");
			}
			
			return mav;
		}
		
		//로그아웃 처리
		@RequestMapping("logout")
		public ModelAndView logout(HttpSession session) {
			
			memberService.logout(session);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("home");
			mav.addObject("msg", "logout");
			
			return mav;
		}
		 /*회원정보 상세 페이지 진입   400error 혹은 jstl 로 값 불러오는데 오류 가있어 못불러옴   ==> 해결*/
		@RequestMapping(value ="/detail" ,method = RequestMethod.GET)
		public String detail(Model model ,HttpSession session)throws Exception{
			
//			memberService.detail(userid);
//			logger.info("이름 :" + member.game());
//			logger.info("휴대폰 :" + member.getNumber());
			String userid = (String) session.getAttribute("userid"); //session 넘기는 부분
			Member member = memberService.detail(userid);
		
			
			model.addAttribute("member" ,member);
		
			return "board/detail";
			
    }
//		/*회원정보 수정*/
//		@RequestMapping(value="/update", method = RequestMethod.GET)
//		public String update(Model model ,HttpSession session ) throws Exception{
//
//			
//			String userid = (String) session.getAttribute("userid");
//			int member = memberService.update(userid);
//			model.addAttribute("member" ,member);
//
//			
//			return "/board/update";
//		}
		
		
		/*아이디 찿기 관련부분*/
		@RequestMapping(value="/findIdView", method=RequestMethod.GET)
		public String findIdView() throws Exception{
			return"/board/findIdView";
		}
		
		
		/*아이디 찿기 성공시 이동페이지*/
		@RequestMapping(value="/findId", method=RequestMethod.POST)
		public String findId(Member member,Model model) throws Exception{
			//logger.info("email"+member.getEmail());// 로그 찍는 부분
					
			model.addAttribute("member" ,member);   // 넘겨줘야 jstl 로 값 읽어오기 가능
			if(memberService.findIdCheck(member.getEmail())==0) {
			model.addAttribute("msg", "해당 이메일로 가입된 정보가 없습니다");
			return "/board/findIdView";
			}else {
			model.addAttribute("member", memberService.findId(member.getEmail()));
			return
					"/board/findId";
			}
		}
		
			
		/*비밀번호 찿기(해당 메일 노출 되고 메일로 전달되었다는 페이지 노출(로그형식 jsp) 추후 없앨예정)*/
		@RequestMapping(value="/findPwView" , method=RequestMethod.GET)
		public String findPwView() throws Exception{
			
			
//			// Mail Server 설정
//			String charSet = "utf-8";
//			String hostSMTP = "smtp.naver.com";		
//			String hostSMTPid = "ddang0103@naver.com"; // 본인의 아이디 입력		
//			String hostSMTPpwd = "1"; // 비밀번호 입력
//			
//			// 보내는 사람 EMail, 제목, 내용 
//			String fromEmail = "ddang0103@naver.com"; // 보내는 사람 eamil
//			String fromName = "ddang0103";  // 보내는 사람 이름
//			String subject = "이메일 발송 테스트"; // 제목
//			
//			// 받는 사람 E-Mail 주소
//			String mail = "ddang0103@naver.com";  // 받는 사람 email		
//			
//			try {
//				HtmlEmail email = new HtmlEmail();
//				email.setDebug(true);
//				email.setCharset(charSet);
//				email.setSSL(true);
//				email.setHostName(hostSMTP);
//				email.setSmtpPort(587);	// SMTP 포트 번호 입력
//
//				email.setAuthentication(hostSMTPid, hostSMTPpwd);
//				email.setTLS(true);
//				email.addTo(mail, charSet);
//				email.setFrom(fromEmail, fromName, charSet);
//				email.setSubject(subject);
//				email.setHtmlMsg("<p>이메일 발송 테스트 입니다.</p>"); // 본문 내용
//				email.send();			
//			} catch (Exception e) {
//				System.out.println(e);
//			}
			
			return"/board/findPwView";
		}
		
		/*비밀번호 찿기페이지(가입했던 아이디 , 이메일 입력창)*/	
		@RequestMapping(value="/findPw", method=RequestMethod.POST)
		public String findPw(Member member ,Model model) throws Exception{
			logger.info("memberPw"+member.getUserid());
			
			if(memberService.findPwCheck(member)==0) {
				logger.info("memberPWCheck");
				model.addAttribute("msg", "아이디와 이메일를 확인해주세요");
				
				return "/board/findPwView";
			}else {
		
			memberService.findPw(member.getEmail(),member.getUserid());
			model.addAttribute("member", member.getEmail());
			
			return"/board/findPw";
			}
		}
		
		/*Mail Sender for email start  ToDo*/

		/*Mail Sender part finish*/

		
		

		/*naver login Api info  (ddang0103 내 개인 이메일 계정으로됨)
		Client Id :  ctfYqsYWlICd4PpzYwkV  
			Client  Secret   :QR38Rmp9o2

		After Login Router :http://localhost:8080/board/listSearch?num=1
		 */
		

		/*Naver APi 연동 부분 코드 현재 로그인 이슈 있음*/
		/* NaverLoginBO */
		private NaverLoginBO naverLoginBO;
		private String apiResult = null;
		@Autowired
		private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
		}
		//로그인 첫 화면 요청 메소드
		@RequestMapping(value = "login", method = { RequestMethod.GET, RequestMethod.POST })
		public String login(Model model, HttpSession session) {
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		//네이버
		model.addAttribute("url", naverAuthUrl);
		return "board/login";
		}
		//네이버 로그인 성공시 callback호출 메소드
		@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
		public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException, org.json.simple.parser.ParseException {
		System.out.println("여기는 callback"); // 로그용
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		//1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); //String형식의 json데이터
		/** apiResult json 구조
		{"resultcode":"00",
		"message":"success",
		"response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		**/
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		//3. 데이터 파싱
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		//response의 nickname값 파싱
		String nickname = (String)response_obj.get("nickname");
		System.out.println(nickname);
		//4.파싱 닉네임 세션으로 저장
		session.setAttribute("sessionId",nickname); //세션 생성
		model.addAttribute("result", apiResult);
		return "/board/listSearch?num=1";
		}
		//로그아웃
		@RequestMapping(value = "logout", method = { RequestMethod.GET, RequestMethod.POST })
		public String Naverlogout(HttpSession session)throws IOException {
		System.out.println("여기는 logout");
		session.invalidate();
		return "redirect:/";
		}
		
		/*--------------------------------------------------------------------------------------------------------------*/
		
		/*Logout Redirect URI : http://localhost:8080/board/login*/
		/*Login Redirect URI : Logout Redirect URI	 http://localhost:8080/board/listSearch?num=1(게시판 페이지로 이동)*/
	/*kakao login api 관련부분*/	

	@RequestMapping(value = "/login/getKakaoAuthUrl")
	public @ResponseBody String getKakaoAuthUrl(
			HttpServletRequest request) throws Exception {
		String reqUrl = 
				"https://kauth.kakao.com/oauth/authorize"
				+ "?client_id=debc8ff12b94f0e9a1b01ae84b38beff"    //clientKey ==> RestApi Key
				+ "&redirect_uri=http://localhost:8080/board/login"
				+ "&response_type=code";
		
		return reqUrl;
	}
	
	// 카카오 연동정보 조회
	@RequestMapping(value = "/login/oauth_kakao")
	public String oauthKakao(
			@RequestParam(value = "code", required = false) String code
			, Model model) throws Exception {

		System.out.println("#########" + code);
        String access_Token = getAccessToken(code);
        System.out.println("###access_Token#### : " + access_Token);
        
        
        HashMap<String, Object> userInfo = getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
       
        JSONObject kakaoInfo =  new JSONObject(userInfo);
        model.addAttribute("kakaoInfo", kakaoInfo);
        
        return "/";
	}
	
    //토큰발급
	public String getAccessToken (String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //  URL연결은 입출력에 사용 될 수 있고, POST 혹은 PUT 요청을 하려면 setDoOutput을 true로 설정해야함.
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //	POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=f8071907fae4877f2a0f469e969f639f");  //본인이 발급받은 key
            sb.append("&redirect_uri=http://localhost:8080/board/login");     // 본인이 설정해 놓은 경로
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            //    결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return access_Token;
    }
	
    //유저정보조회
    public HashMap<String, Object> getUserInfo (String access_Token) {

        //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();
            
            userInfo.put("accessToken", access_Token);
            userInfo.put("nickname", nickname);
            userInfo.put("email", email);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
    }
		/*Kakao login api 끝*/
}
		
 