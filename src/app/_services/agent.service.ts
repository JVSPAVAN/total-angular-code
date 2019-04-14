import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { Agent } from '../_models/agent';
import { pipe } from '@angular/core/src/render3';
import {map} from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class AgentService {
  // private baseUrl = 'http://localhost:8081/Fastrack/FastrackServlet';
resp: Response;

headers: Headers;

  constructor(private http: Http) {
     this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Access-Control-Allow-Origin', '*');

   }

  registerAgent(agent: Agent): Observable<Agent[]> {
   console.log('in web');
   const agentfirst = agent.agentfirst;
   console.log('in update userfirst--' + agentfirst);
   const agentmiddle = agent.agentmiddle;
   console.log('in update usermiddle--' + agentmiddle);
   const agentlast = agent.agentlast;
   console.log('in update userlast--' + agentlast);
   const agentdob = agent.agentdob;
   console.log('in update userdob--' + agentdob);
   const agentaddr = agent.agentaddr;
   console.log('in update gender--' + agentaddr);
   const agentexp = agent.agentexp;
   console.log('in update userpermaddr--' + agentexp);
   const agentemail = agent.agentemail;
   console.log('in update userpresentaddr--' + agentemail);
   const agentphone = agent.agentphone;
   console.log('in update useroccupation--' + agentphone);
   const agentpan = agent.agentpan;
   console.log('in update usersalary--' + agentpan);
   const agentzone = agent.agentzone;
   console.log('in update marital--' + agentzone);
   const agentref = agent.agentref;
   console.log('in update userchildren--' + agentref);
   // tslint:disable-next-line:max-line-length
   const  url = 'http://172.24.129.175:8081/Fastrack/FastrackServlet?action=addagent&agentfirst=' + agentfirst + '&agentmiddle=' + agentmiddle
                + '&agentlast=' + agentlast +
    '&agentdob=' + agentdob + '&agentaddr=' + agentaddr + '&agentexp=' + agentexp + '&agentemail=' + agentemail +
   '&agentphone=' + agentphone + '&agentpan=' + agentpan + '&agentzone=' + agentzone + '&agentref=' + agentref;
       console.log('url-->' + url);
  return this.http.get(url).pipe(
          map ((resp) => {
                     return <Agent[]>this.handleResponse(resp);
                  }
              ));
  }




 handleResponse(resp: any) {
    if (resp instanceof Response) {
        console.log('resp' + resp);
        if (resp.ok === true) {
            console.log('resp' + resp);
            console.log('text == ' + resp.text());
            console.log('json-->' + resp.json().Agent);

            return resp.json().Agent;
          }
            return resp;
    } else {
        return resp;
    }

}

}


