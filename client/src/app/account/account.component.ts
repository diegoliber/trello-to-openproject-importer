import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

import { AccountService, Account } from './account.service';


@Component({
    moduleId: module.id,
    selector: 'account',
    templateUrl: './account.component.html',
    styleUrls: ['./account.component.css']
})
export class AccountFormComponent implements OnInit {

    @Input() public account: Account = new Account();

    constructor(private service : AccountService, private router: Router) {

    }

    ngOnInit() {
        this.service.getAccount().subscribe(res => {
            var json = res.json();
            console.debug("Received JSON from account service: " + JSON.stringify(json));
            this.account = json;
            console.info("Received account for username: " + this.account.username);
        },err => {
            console.error("Problem getting account");
        });
    }

    updateTrelloToken(event) {
        this.service.logout();
        this.service.login();
    }

    storeOpenProjectToken(event) {
        this.service.storeOpenProjectToken(this.account.openProjectToken);
    }

}