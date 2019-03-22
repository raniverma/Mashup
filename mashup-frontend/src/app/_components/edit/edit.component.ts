import { Component, OnInit, OnDestroy } from '@angular/core';
import { DiffEditorModel, NgxEditorModel } from 'ngx-monaco-editor';
import { QuestioExeEngineService } from '../../services/questio-exe-engine.service';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { autocomplete } from './autocomplete';
import { TokenStorageService } from '../../services/token-storage.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DialogService } from 'src/app/services/dialog.service';


@Component({

  selector: 'app-edit',
  styles: ['ngx-monaco-editor { height: 70vh; width:100%; display:block; }', `ul{
    list-style-type: none;
  }`],
  styleUrls: [],
  templateUrl: './edit.component.html'


})
export class EditComponent implements OnInit {
 
    serverUrl='http://13.234.74.67:8025/gkz-stomp-endpoint';
   // title='WebSockets demo';
  // wesocket
  public statement=false;
  public flag=false;
  public flag2=false;
  title = 'grokonez';
  public difficulty: String;
  public uname: String;
  public testpass: String;
  public totaltest: String;
  description = 'Angular-WebSocket Demo';

  greetings: string[] = [];

  disabled = true;
 code: String;
  private stompClient = null;

  // socket ends here
  questionObj: String;
  result: String;
  auto = new autocomplete;
  questionId;
    questionTitle: String;
    questionDescription: String ;
    inputFormat: String[];
    outputFormat: String[];
    inputFormat1: String;
    outputFormat1: String;
    tags: String;
    gitUrl: String;
  selectedLang = 'java';
  editorOptions = { theme: 'vs-dark', language: 'java' };

  // ngOnDestroy(){
  //   console.log("calling ngondestroy");
  //   this.quesservice.removeNodemon(this.uname);
  // }
  selectChangeHandler(event: any) {
    // update the ui
    this.selectedLang = event.target.value;
    this.editorOptions = { theme: 'vs-dark', language: this.selectedLang };
    if (this.selectedLang === 'java') {
      monaco.languages.registerCompletionItemProvider(this.selectedLang, this.auto.getJavaCompletionProvider(monaco));
    } else
      if (this.selectedLang === 'python') {
        monaco.languages.registerCompletionItemProvider(this.selectedLang, this.auto.getPythonCompletionProvider(monaco));
      } else
        if (this.selectedLang === 'cpp') {
          monaco.languages.registerCompletionItemProvider(this.selectedLang, this.auto.getCppCompletionProvider(monaco));
        } else {
          monaco.languages.registerCompletionItemProvider(this.selectedLang, this.auto.getCCompletionProvider(monaco));
        }
  }

  onInit(editor) {
    const line = editor.getPosition();
    const monaco = window['monaco'];
    monaco.languages.registerCompletionItemProvider(this.selectedLang, this.auto.getJavaCompletionProvider(monaco));

  }
  constructor(public quesservice: QuestioExeEngineService, private _route: ActivatedRoute, private token: TokenStorageService, private dialogService: DialogService, private router: Router) {
 
            // this.initializeWebSocketConnection();
  }
  ngOnInit() {
    this.questionId = this._route.snapshot.paramMap.get('qid');
    this.uname = this.token.getUsername();
    
     this.quesservice.getQuestionById(this.questionId).subscribe(
      data => {
       this.questionObj = data;
       this.initializeWebSocketConnection();
        this.questionId = data['questionId'];
        this.questionTitle = data['questionTitle'] ;
        this.questionDescription = data['questionDescription'] ;
        this.inputFormat1 = data['inputFormat'] ;
       this.inputFormat = this.inputFormat1.split('\n');
       this.outputFormat1 = data['outputFormat'];
        this.outputFormat = this.outputFormat1.split('\n');
        this.difficulty = data['difficulty'] ;
        this.tags = data['tags'] ;
        this.gitUrl = data['gitUrl'] ;
        // tslint:disable-next-line:no-shadowed-variable
        this.quesservice.getcode(this.gitUrl, this.uname).subscribe(data => {
          this.code = data['codeTemplate'];  });
        }
        );
  }
  // tslint:disable-next-line:member-ordering
  options = {theme: 'vs-dark'};
  // tslint:disable-next-line:member-ordering
  jsonCode = [
    '{',
    '    "p1": "v3",',
    '    "p2": false',
    '}'
  ].join('\n');

  // tslint:disable-next-line:member-ordering
  model: NgxEditorModel = {
    value: this.jsonCode,
    language: 'json',
    uri: 'foo.json',

  };
  // tslint:disable-next-line:member-ordering
  originalModel: DiffEditorModel = {
    code: 'heLLo world!',
    language: 'text/plain'
  };

  // tslint:disable-next-line:member-ordering
  modifiedModel: DiffEditorModel = {
    code: 'hello orlando!',
    language: 'text/plain'
  };

  // socket code
  setConnected(connected: boolean) {
    this.disabled = !connected;

    if (connected) {
      this.greetings = [];
    }
  }
  initializeWebSocketConnection() {
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    that.setConnected(true);
    this.stompClient.connect(
      {},
      function(frame) {
        that.stompClient.subscribe('/topic', message => {
        that.showGreeting(JSON.parse(message.body).codeTemplate);
        });
      }
    );
  }
  
  disconnect() {
    if (this.stompClient != null) {
      this.stompClient.disconnect();
    }

    this.setConnected(false);
  }

  submit() {
    this.greetings = [];
    this.stompClient.send(
      '/gkz/hello',
      {},
      JSON.stringify({'name': this.uname + '@#' + this.code })
    );
    this.flag=true;
  }

 // tslint:disable-next-line:member-ordering
 public colorg: object = {};
 sendDataToSubmissionService() {
      this.dialogService.openConfirmDialog("Are you sure ?")
      .afterClosed().subscribe(res =>{
        if(res){
          this.quesservice.sendDatatoSubmission({'code': this.code, 'username': this.uname, 'questionId': this.questionId,
          'questionTitle': this.questionTitle, result: this.result,
          'testCasePassed': this.testpass, 'totalTestCases': this.totaltest,
          'difficulty': this.difficulty});
          this.router.navigate(['']);
        }
      });
 }
  showGreeting(message) {
    this.statement = false;
    this.flag2 = true;
    this.flag = false;
    this.greetings.push(message);
    if ( !this.greetings[0].includes('statement') && !this.greetings[0].includes(';') && !this.greetings[0].includes('missing') && !this.greetings[0].includes('cannot'))
    {
      this.statement = true;
    }
    this.greetings = this.greetings[0].split('@*#');
    this.totaltest = this.greetings[0];
    this.testpass = this.greetings[1];
    this.greetings = this.greetings[2].split('\n');
    if (this.greetings[0] === '') {
    this.greetings[0] = 'Tests passed';
  }
    this.colorg = {
      color: `red`
    };
    if ( this.greetings[0] === 'Tests passed') {
      this.result = 'passed';
      this.colorg = {
        color: `green`
      };
    } else {
      this.result = 'failed';
    }
  }

}