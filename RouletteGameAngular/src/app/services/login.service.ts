// import { ValidateUser } from '../users/model/validate_user.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from "rxjs/index";
import { UserLogin } from '../model/login_info.model';
// import { Observable } from 'rxjs';
import { ValidateUser } from '../model/validate_user.model';
// import { ApiResponse } from '../model/api_response.model';
// import { HomeComponent } from '../users/home/home.component';
import { loginUri } from '../constants/uri';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  // private readonly loginURI = "http://localhost:8080/RouletteAPI/webapi/validate/validateUser";
  private readonly loginURI = loginUri;

  

  constructor(private httpClient: HttpClient) { }

  validateUser(loginFormData: UserLogin): Observable<ValidateUser> {
    return this.httpClient.get<ValidateUser>(this.loginURI + '/' + loginFormData.customerID);
  };


}
