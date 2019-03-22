import { EditaudioComponent } from './_components/editaudio/editaudio.component';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { NgxSpinnerModule } from 'ngx-spinner';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AppComponent } from './app.component';
import { LoginComponent } from './_components/login/login.component';
import { UserComponent } from './_components/user/user.component';
import { HomeComponent } from './_components/home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ErrorInterceptor } from './_helpers/error.interceptor';
import { JwtInterceptor  } from './_helpers/jwt.interceptor';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { RegisterComponent } from './_components/register/register.component';
import { NgxPageScrollModule } from 'ngx-page-scroll';
import { NgxPageScrollCoreModule } from 'ngx-page-scroll-core';
import {A11yModule} from '@angular/cdk/a11y';
import {DragDropModule} from '@angular/cdk/drag-drop';
import {ScrollingModule} from '@angular/cdk/scrolling';
import {CdkStepperModule} from '@angular/cdk/stepper';
import {CdkTableModule} from '@angular/cdk/table';
import {CdkTreeModule} from '@angular/cdk/tree';
import {SavequestionComponent} from './_components/savequestion/savequestion.component';
import { ResizableModule } from 'angular-resizable-element';
import { OwlModule } from 'ngx-owl-carousel';
import { MonacoEditorModule, NgxMonacoEditorConfig } from 'ngx-monaco-editor';
import { httpInterceptorProviders } from './_components/auth/auth-interceptor';
import {
  MatAutocompleteModule,
  MatBadgeModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
} from '@angular/material';
import { EditComponent } from './_components/edit/edit.component';
import { from } from 'rxjs';
import { UserprofileComponent } from './_components/userprofile/userprofile.component';
import { UserprofileServiceService } from './services/userprofile-service.service';
import { RecommendComponent } from './_components/recommend/recommend.component';
import { RouterModule } from '@angular/router';
import { SubmissionComponent } from './_components/submission/submission.component';
import { VotingComponent } from './_components/voting/voting.component';
import { NavbarComponent } from './_components/navbar/navbar.component';
import { FooterComponent } from './_components/footer/footer.component';
import { ScoreandbadgeComponent } from './_components/scoreandbadge/scoreandbadge.component';
import { LandingComponent } from './_components/landing/landing.component';
import { SearchserviceComponent } from './_components/searchservice/searchservice.component';
import { SearchdisplayComponent } from './_components/searchdisplay/searchdisplay.component';
import { MatdialogComponent } from './_components/matdialog/matdialog.component';
import { SocialbarComponent } from './_components/socialbar/socialbar.component';
import { AlertComponent } from './_components/alert/alert.component';

const monacoConfig: NgxMonacoEditorConfig = {
  baseUrl: 'assets',         // configure base path for monaco editor
  defaultOptions: { scrollBeyondLastLine: false },
  onMonacoLoad: () => {
    console.log((<any>window).monaco);
    const id = 'foo.json';
    monaco.languages.json.jsonDefaults.setDiagnosticsOptions({
      validate: true,
      schemas: [{
        uri: 'http://myserver/foo-schema.json',
        fileMatch: [id],
        schema: {
          type: 'object',
          properties: {
            p1: {
              enum: [ 'v1', 'v2']
            },
            p2: {
              $ref: 'http://myserver/bar-schema.json'
            }
          }
        }
      }, {
        uri: 'http://myserver/bar-schema.json',
        fileMatch: [id],
        schema: {
          type: 'object',
          properties: {
            q1: {
              enum: [ 'x1', 'x2']
            }
          }
        }
      }]
    });
  }
};

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    RegisterComponent,
    HomeComponent,
    EditComponent,
    SavequestionComponent,
    UserprofileComponent,
    RecommendComponent,
    SubmissionComponent,
    VotingComponent,
    NavbarComponent,
    FooterComponent,
    ScoreandbadgeComponent,
    LandingComponent,
    SearchserviceComponent,
    EditaudioComponent,
    SearchdisplayComponent,
    MatdialogComponent,
    SocialbarComponent,
    AlertComponent,
  ],
  imports: [
    BrowserModule,
    OwlModule,
    NgxPageScrollModule,
    NgxPageScrollCoreModule,
    AppRoutingModule,
    ResizableModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatNativeDateModule,
    A11yModule,
    CdkStepperModule,
    CdkTableModule,
    CdkTreeModule,
    DragDropModule,
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
    ScrollingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    HttpModule,
    NgxSpinnerModule,
    FlexLayoutModule,
    MonacoEditorModule.forRoot(monacoConfig),
    RouterModule.forRoot([
      {path: 'fetch', component: RecommendComponent},
      {path: 'voting', component:VotingComponent}
    ])
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    httpInterceptorProviders,
    UserprofileServiceService
  ],
  bootstrap: [AppComponent],
  entryComponents:[MatdialogComponent]
})
export class AppModule { }
