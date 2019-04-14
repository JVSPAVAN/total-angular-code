import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { Manager } from '../_models/manager';
import { pipe } from '@angular/core/src/render3';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

resp: Response;

headers: Headers;

  constructor(private http: Http) {
     this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Access-Control-Allow-Origin', '*');

   }

    registerManager(manager: Manager): Observable<Manager[]> {
   console.log('in web');
   const mangfirst = manager.mangfirst;
   console.log('in update userfirst--' + mangfirst);
   const mangdob = manager.mangdob;
   console.log('in update usermiddle--' + mangdob);
   const mangstate = manager.mangstate;
   console.log('in update userlast--' + mangstate);
   const mangzone = manager.mangzone;
   console.log('in update userdob--' + mangzone);
   const mangdesg = manager.mangdesg;
   console.log('in update gender--' + mangdesg);
   const mangemail = manager.mangemail;
   console.log('in update userpermaddr--' + mangemail);
   // tslint:disable-next-line:max-line-length
   const  url = 'http://172.24.129.175:8081/Fastrack/FastrackServlet?action=addmanager&mangfirst=' + mangfirst + '&mangdob=' + mangdob
                + '&mangstate=' + mangstate +
    '&mangzone=' + mangzone + '&mangdesg=' + mangdesg + '&mangemail=' + mangemail ;
       console.log('url-->' + url);
  return this.http.get(url).pipe(
          map ((resp) => {
                     return <Manager[]>this.handleResponse(resp);
                  }
              ));
  }

 handleResponse(resp: any) {
    if (resp instanceof Response) {
        console.log('resp' + resp);
        if (resp.ok === true) {
            console.log('resp' + resp);
            console.log('text == ' + resp.text());
            console.log('json-->' + resp.json().Manager);

            return resp.json().Manager;
          }
            return resp;
    } else {
        return resp;
    }

}
}
