import { Injectable, OnInit } from '@angular/core';
import { Http, Headers, RequestOptions, URLSearchParams, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

const ACCESS_TOKEN_KEY : string = "trello.accessToken"

@Injectable()
export class AccountService {

    
    private apiKeyStr : string;
     
    constructor(private http: Http, private router: Router) {

    }

    public isLoggedIn() : boolean {
        
        var token = localStorage.getItem(ACCESS_TOKEN_KEY);
        if (token != undefined && token != null && token != "") {
            return true;
        }

        return false;
    }

    public login() {
        var location = window.location.href;

        console.info("Callback URL: " + location);

        window.location.href = '/api/account/login?callbackUrl=' + encodeURI(location);
    }

    public logout() {
        localStorage.removeItem(ACCESS_TOKEN_KEY);   
    }

    handleFragment(fragment: string) {
        console.info("URL Fragment received: " + fragment);
        if (fragment != null && fragment.length > 0) {
            var parts = fragment.split('=');
            if (parts.length == 2 && parts[0] == 'token') {
                var token = parts[1];
                console.info("Got token " + token);
                localStorage.setItem(ACCESS_TOKEN_KEY,token);
                var headers = new Headers();
                headers.set("Content-Type", "text/plain");
                this.http.post("/api/account/trello/token", token, {headers: headers}).subscribe(res => {
                    console.log("Token registered successfully")
                }, err => {
                    console.error("Problem while registering token on the backend: " + err)
                });
            }
        }
    }

    public getAuthHeaders(): Headers {
        var headers = new Headers();
        headers.set("X-Access-Token", localStorage.getItem(ACCESS_TOKEN_KEY));
        return headers;
    } 

    getAccount() : Observable<Response> {
        return this.http.get("/api/account", {headers: this.getAuthHeaders()});
    }

    public storeOpenProjectToken(token : string): Observable<Response> {
        var headers = this.getAuthHeaders();
        headers.set("Content-Type","text/plain");
        var observable = this.http.post("/api/account/openproject/token", token, {headers: headers});
        
        observable.subscribe(res => {
            console.info("Open Project token stored and validated successfully");
        }, err => {
            console.error("Problem while storing open project token" + err);
        });

        return observable;
    }
    
}


export class Account {

    constructor(public username: string = undefined, 
        public trelloToken: string = undefined, 
        public fullName: string = undefined, 
        public trelloId: string = undefined, 
        public openProjectToken: string = undefined) {
        
    }

}