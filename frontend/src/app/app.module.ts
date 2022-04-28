import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { VotingComponent } from './voting/voting.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import { RegisterVoteComponent } from './register-vote/register-vote.component';
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    VotingComponent,
    RegisterVoteComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
