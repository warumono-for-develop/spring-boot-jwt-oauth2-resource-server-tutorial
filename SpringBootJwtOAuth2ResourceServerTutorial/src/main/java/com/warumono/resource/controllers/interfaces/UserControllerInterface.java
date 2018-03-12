package com.warumono.resource.controllers.interfaces;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.warumono.resource.enums.Authority;
import com.warumono.resource.helpers.AppConstant.Swagger.DataType;
import com.warumono.resource.helpers.AppConstant.Swagger.ParamType;
import com.warumono.resource.helpers.AppConstant.Swagger.Tag;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "/user", tags = { "UserController" })
@RequestMapping(value = "/user")
public interface UserControllerInterface
{
//	@PreAuthorize("hasRole('USER')")
	@ApiOperation(value = "사용자 정보", notes = "사용자 정보를 조회한다.<br/>", tags = { Tag.INCOMPLETED })
	@ApiImplicitParams({})
	@GetMapping(value = "me")
	Principal me(Principal principal);

//	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "접근 권한 테스트", notes = "접근 권한에 따른 정보를 제공하는 API 테스트한다.<br/>", tags = { Tag.TEST })
	@ApiImplicitParams({ @ApiImplicitParam(name = "identity", value = "User identity", dataType = DataType.STRING, paramType = ParamType.PATH, required = false) })
	@GetMapping(value = "test/profile/{identity}")
	ResponseEntity<Object> test(@PathVariable(value = "identity") String identity);
	
	@ApiOperation(value = "사용자 정보 저장", notes = "전체 정보 목록을 조회한다.<br/>", tags = { Tag.INCOMPLETED })
	@ApiImplicitParams
	({
		@ApiImplicitParam(name = "authority", value = "권한", dataType = "Authority", paramType = ParamType.PATH, required = false, defaultValue = "USER"), 
		@ApiImplicitParam(name = "username", value = "아이디", dataType = "Authority", paramType = ParamType.QUERY, required = false), 
		@ApiImplicitParam(name = "password", value = "비밀번호", dataType = "Authority", paramType = ParamType.QUERY, required = false)
	})
	@PostMapping(value = "me")
	ResponseEntity<Object> me
	(
		@PathVariable(value = "authority") Authority authority, 
		@RequestParam(value = "username", required = true) String username, 
		@RequestParam(value = "password", required = false) String password
	);
}
