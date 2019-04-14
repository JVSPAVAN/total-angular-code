import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { User } from '../_models/user';
import { pipe } from '@angular/core/src/render3';
import {map} from 'rxjs/operators';


@Injectable()
export class UserService {
    private baseUrl = 'http://localhost:8081/Fastrack/FastrackServlet';

    user: User[];
    resp: Response;
    headers: Headers;

  constructor(private http: Http) {
  this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Access-Control-Allow-Origin', '*');

   }

getAll(): Observable<User[]> {
       return this.http.get(this.baseUrl).pipe(map((resp) => {
        return this.handleResponse(resp);
    }));
  }

  registerUser(user: User): Observable<User[]> {
   console.log('in web');
   const userfirst = user.userfirst;
   console.log('in update userfirst--' + userfirst);
   const usermiddle = user.usermiddle;
   console.log('in update usermiddle--' + usermiddle);
   const userlast = user.userlast;
   console.log('in update userlast--' + userlast);
   const userdob = user.userdob;
   console.log('in update userdob--' + userdob);
   const gender = user.gender;
   console.log('in update gender--' + gender);
   const userpermaddr = user.userpermaddr;
   console.log('in update userpermaddr--' + userpermaddr);
   const userpresentaddr = user.userpresentaddr;
   console.log('in update userpresentaddr--' + userpresentaddr);
   const useroccupation = user.useroccupation;
   console.log('in update useroccupation--' + useroccupation);
   const usersalary = user.usersalary;
   console.log('in update usersalary--' + usersalary);
   const marital = user.marital;
   console.log('in update marital--' + marital);
   const userchildren = user.userchildren;
   console.log('in update userchildren--' + userchildren);
   const useremail = user.useremail;
   console.log('in update useremail--' + useremail);
   const userphone = user.userphone;
   console.log('in update userphone--' + userphone);
   const userpan = user.userpan;
   console.log('in update userpan--' + userpan);
   // tslint:disable-next-line:max-line-length
   const  url = 'http://172.24.129.175:8081/Fastrack/FastrackServlet?action=adduser&userfirst=' + userfirst + '&usermiddle=' + usermiddle + '&userlast=' + userlast +
   '&userdob=' + userdob + '&gender=' + gender + '&userpermaddr=' + userpermaddr + '&userpresentaddr=' + userpresentaddr +
   '&useroccupation=' + useroccupation + '&usersalary=' + usersalary + '&marital=' + marital + '&userchildren=' + userchildren +
   '&useremail=' + useremail + '&userphone=' + userphone + '&userpan=' + userpan;
       console.log('url-->' + url);
  return this.http.get(url).pipe(
          map ((resp) => {
                     return <User[]>this.handleResponse(resp);
                  }
              ));
  }




 handleResponse(resp: any) {
    if (resp instanceof Response) {
        console.log('resp' + resp);
        if (resp.ok === true) {
            console.log('resp' + resp);
            console.log('text == ' + resp.text());
            console.log('json-->' + resp.json().User);

            return resp.json().User;
          }
            return resp;
    } else {
        return resp;
    }

}

getUserDetails(): Observable<User[]> {

    return this.http.post('http://172.24.129.175:8081/Fastrack/FastrackServlet?action=ViewUser', '').pipe(map((resp) => {
        return this.handleResponse(resp);
    } ) );
}

}

updateUser(user: User): Observable<User[]> {
   console.log('in web updated details');
   const userpermaddr = user.userpermaddr;
   console.log('in update userpermaddr--' + userpermaddr);
   const userpresentaddr = user.userpresentaddr;
   console.log('in update userpresentaddr--' + userpresentaddr);
   const useroccupation = user.useroccupation;
   console.log('in update useroccupation--' + useroccupation);
   const usersalary = user.usersalary;
   console.log('in update usersalary--' + usersalary);
   const marital = user.marital;
   console.log('in update marital--' + marital);
   const userchildren = user.userchildren;
   console.log('in update userchildren--' + userchildren);
   const useremail = user.useremail;
   console.log('in update useremail--' + useremail);
   const userphone = user.userphone;
   console.log('in update userphone--' + userphone);
   const userpan = user.userpan;
   console.log('in update userpan--' + userpan);
   // tslint:disable-next-line:max-line-length
   const  url = 'http://172.24.129.175:8081/Fastrack/FastrackServlet?action=updateuser&userpermaddr=' + userpermaddr + '&userpresentaddr=' + userpresentaddr +
   '&useroccupation=' + useroccupation + '&usersalary=' + usersalary + '&marital=' + marital + '&userchildren=' + userchildren +
   '&useremail=' + useremail + '&userphone=' + userphone + '&userpan=' + userpan;
       console.log('url-->' + url);
       let myParams = new URLSearchParams();
        myParams.append('custid', Cust_Id);  

        let options = new RequestOptions({ headers: this.headers, params: myParams });
  return this.http.get(url).pipe(
          map ((resp) => {
                     return <User[]>this.handleResponse(resp);
                  }
              ));
  }

deleteUser(user: User): Observable<User> {
    var custid=user.Cust_Id;
    console.log('in delete custid--' + custid);
    const url ='http://172.24.129.175:8081/Fastrack/FastrackServlet?Cust_Id=' + custid + '&action=Delete';
    return this.http.get(url).pipe(map((resp) => {
    return this.handleResponse(resp);
    }));
}


function mapUsers(response: Response): User[] {
  return response.json().map(toUser);
}

function mapUser(response: Response): User {
  return toUser(response.json());
}

function toUser(u: any): User {
  return u;
}
