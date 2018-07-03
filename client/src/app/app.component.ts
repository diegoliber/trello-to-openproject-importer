import { Component } from '@angular/core';
import { AccountService } from './account/account.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private accountService: AccountService, 
    
    private activatedRoute : ActivatedRoute,
    private router : Router) {

  }
  
  ngOnInit() {
    this.activatedRoute.fragment.subscribe((fragment: string) => {
      console.log("Current URL fragment: " + fragment)
      if (fragment != undefined && fragment != "") {
        this.accountService.handleFragment(fragment);
      }
    })
  }

  public isLoggedIn(): boolean {
    
    return this.accountService.isLoggedIn();
  }

  public login(event) {
    this.accountService.login();
  }

  public logout(event) {
    this.accountService.logout();
  }

}
