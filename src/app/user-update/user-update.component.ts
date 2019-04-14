import { Component, OnInit } from '@angular/core';
import {UserService} from '../_services/user.service';
import {Form, FormBuilder, FormGroup, Validators} from '@angular/forms';
import { User } from '../_models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

  user: User;
  message: string;
  formgroup: FormGroup;

  constructor(private fb: FormBuilder, private serviceUser: UserService, private router: Router) {
    this.createform();
  }

 createform() {
    this.formgroup = this.fb.group(
        userpermaddr: ['', Validators.required] ,
        userpresentaddr: ['', Validators.required] ,
        useroccupation: ['', Validators.required] ,
        usersalary: ['', Validators.required] ,
        marital: ['', Validators.required] ,
        userchildren: ['', Validators.required] ,
        useremail: ['', Validators.required] ,
        userphone: ['', Validators.required] ,
        userpan: ['', Validators.required] ,
    });
  }

ngOnInit() {
  }

  submitup() {
      console.log(this.formgroup.value);
      this.user = this.formgroup.value;
      this.serviceUser.updateUser(this.user).subscribe((data) => {
          this.message = 'User is Updated Successfully'; });
          alert(this.message);
            this.formgroup.reset({
          Address: '',
          userpermaddr: '',
          userpresentaddr: '',
          useroccupation: '',
          usersalary: '',
          marital: '',
          userchildren: '',
          useremail: '',
          userphone: '',
          userpan: ''
      });
      this.router.navigate(['/customer-home.component']);

  }

}