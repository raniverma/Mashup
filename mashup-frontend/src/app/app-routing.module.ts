import { SearchdisplayComponent } from './_components/searchdisplay/searchdisplay.component';
import { SearchserviceComponent } from './_components/searchservice/searchservice.component';
import { VotingComponent } from './_components/voting/voting.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './_components/login/login.component';
import { HomeComponent } from './_components/home/home.component';
import { UserComponent } from './_components/user/user.component';
import { RegisterComponent } from './_components/register/register.component';
import { SavequestionComponent} from './_components/savequestion/savequestion.component';
import { EditComponent } from './_components/edit/edit.component';
import { UserprofileComponent } from './_components/userprofile/userprofile.component';
import { SubmissionComponent } from './_components/submission/submission.component';
import { EditaudioComponent } from './_components/editaudio/editaudio.component';

const routes: Routes = [
    { path: 'register',
     component: RegisterComponent
    },
    {
        path: 'home',
        component: HomeComponent,
        data: { state: 'isHome'}
    },
    {
        path: 'userprofile',
        component: UserprofileComponent,
        data: { state : 'isUserprofile'}
    },
    {
        path: 'execution',
        component: EditComponent,
        data: { state : 'isExecution'}
    },
    {
        path: 'execution/:qid',
        component: EditComponent
    },
    {
        path: 'post/:username',
        component: SavequestionComponent
    },
    {
        path: 'user',
        component: UserComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent,
        data: { state : 'isAuth/login'}
    },
    {
        path: 'voting',
        component: VotingComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },
    {
        path: 'submission-component/:qid',
        component: SubmissionComponent
    },
    {
        path: 'search',
        component: SearchserviceComponent
    },
    {
        path: 'editaudio',
        component: EditaudioComponent
    },
    {
        path: 'display/:tag',
        component: SearchdisplayComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
