package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.LoginDto;
import com.unit17.seliganatrilha.dtos.SessaoDto;

public interface LoginService {
     SessaoDto login(LoginDto login);
}
