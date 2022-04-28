import { Component, OnInit } from '@angular/core';
import {Candidate} from "../model/candidate";
import {RestService} from "../service/RestService";

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.css']
})
export class VotingComponent implements OnInit {

  title = 'Galaxy Elections Voting';
  candidates: Candidate[] | undefined;

  constructor(private restService : RestService) {}

  ngOnInit(): void {
    this.getCandidates();
  }

  getCandidates() {
    this.restService.getData('/candidates/all').subscribe((candidates) => {
      this.candidates = candidates;
    }) ;
  }

}
