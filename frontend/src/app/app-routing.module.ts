import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {VotingComponent} from "./voting/voting.component";
import {RegisterVoteComponent} from "./register-vote/register-vote.component";

const appRoutes : Routes = [
  { path: 'voting',               component: VotingComponent },
  { path: 'register-vote', component: RegisterVoteComponent },
  { path: '',
    redirectTo: '/voting',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    ),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
