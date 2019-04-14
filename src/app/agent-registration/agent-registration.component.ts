import { Component, OnInit } from '@angular/core';
import {AgentService} from '../_services/agent.service';
import {Form, FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Agent } from '../_models/agent';

@Component({
  selector: 'app-agent-registration',
  templateUrl: './agent-registration.component.html',
  styleUrls: ['./agent-registration.component.css']
})
export class AgentRegistrationComponent implements OnInit {
  agent: Agent;
  message: string;
  formgroup: FormGroup;
  constructor(private fb: FormBuilder, private serviceAgent: AgentService) {
          this.createform();

   }
   createform() {
    this.formgroup = this.fb.group({
        agentfirst: ['', Validators.required],
        agentmiddle: ['', Validators.required] ,
        agentlast: ['', Validators.required] ,
        agentdob: ['', Validators.required] ,
        agentaddr: ['', Validators.required] ,
        agentexp: ['', Validators.required] ,
        agentemail: ['', Validators.required] ,
        agentphone: ['', Validators.required] ,
        agentpan: ['', Validators.required] ,
        agentzone: ['', Validators.required] ,
        agentref: ['', Validators.required] ,
    });
  }

  ngOnInit() {
  }
   submitAgent() {
      console.log(this.formgroup.value);
      this.agent = this.formgroup.value;
      this.serviceAgent.registerAgent(this.agent).subscribe((data) => {
          this.message = 'Agent is Registered Successfully'; });
            this.formgroup.reset({
        agentfirst: '',
        agentmiddle: '',
        agentlast: '',
        agentdob: '' ,
        agentaddr: '' ,
        agentexp: '' ,
        agentemail: '',
        agentphone: '',
        agentpan: '',
        agentzone: '',
        agentref: ''
      });
  }

}
