import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {RestService} from "../service/RestService";
import {Candidate} from "../model/candidate";

@Component({
  selector: 'app-register-vote',
  templateUrl: './register-vote.component.html',
  styleUrls: ['./register-vote.component.css']
})
export class RegisterVoteComponent implements OnInit {

  title = 'Registered vote';
  vote = '';

  constructor(private route : ActivatedRoute,
              private restService : RestService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.sendVote(params['id'])
    });
  }

  sendVote(id:string) {
    let request = { id : id }
    this.restService.postData('/voting', request).subscribe(response => {
      console.log(response)
      let vote = response as Candidate;
      this.vote = vote.name;
    });
  }

}
