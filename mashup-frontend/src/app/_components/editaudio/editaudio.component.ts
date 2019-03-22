import { Component, OnInit } from '@angular/core';
import { DiffEditorModel } from 'ngx-monaco-editor';
import { NgxEditorModel } from 'ngx-monaco-editor';
import { autocomplete } from './autocomplete';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-editaudio',
  styles: ['ngx-monaco-editor { height: 70vh; width:100%; display:block; }'],
  styleUrls: [],
  templateUrl: './editaudio.component.html',
})
export class EditaudioComponent implements OnInit {
   totaltest: String;
   passed: String;
  // wesocket
  public styleb: object = {};
  title = 'grokonez';
  val = 'true';
  myVar: boolean;
  description = 'Angular-WebSocket Demo';
  greetings: string[] = [];
  disabled = true;
  code = `int bucky = {3,4,5,6,7};
  int total = 0;
  for(int x: bucky) {
    total += x;
  }
  System.out.println("Total = " + total)`;
  readabilityTime = 5 ;
  private stompClient = null;
  editorLoadStatus;
  audiopath = '/assets/audio1.mp3';
  i = 0;
  mvnDependencyDownload = 0;
  // socket ends here
  auto = new autocomplete;
  selectedLang = 'java';
  editorOptions = { theme: 'vs-light', language: 'java', readOnly: 'true' };
  options = {
    theme: 'vs-dark'
  };

  jsonCode = [
    '{',
    '    "p1": "v3",',
    '    "p2": false',
    '}'
  ].join('\n');

  model: NgxEditorModel = {
    value: this.jsonCode,
    language: 'json',
    uri: 'foo.json',

  };

  originalModel: DiffEditorModel = {
    code: 'heLLo world!',
    language: 'text/plain'
  };

  modifiedModel: DiffEditorModel = {
    code: 'hello orlando!',
    language: 'text/plain'
  };

  public colorg: object = { };
  timeStart: number;
  interval;
  changeReadibility (readValue) {
    this.editorOptions = { theme : 'vs-light', language: 'java', readOnly: readValue };
  }

  onInit(editor) {
    const monaco = window['monaco'];
    monaco.languages.registerCompletionItemProvider(this.selectedLang, this.auto.getJavaCompletionProvider(monaco));
  }
  constructor() {}

  ngOnInit() {
    this.connect();
  }
  // socket code
  setConnected(connected: boolean) {
    this.disabled = !connected;
    if (connected) {
      this.greetings = [];
    }
  }
  connect() {
    const socket = new SockJS('http://13.234.74.67:8031/gkz-stomp-endpoint-js');
    this.stompClient = Stomp.over(socket);
    const _this = this;
    this.stompClient.connect({}, function (frame) {
      _this.setConnected(true);
      this.connectedSocket = true;
      _this.stompClient.subscribe('/topic-js/hi', function (hello) {
        if ( _this.mvnDependencyDownload > 1) {
          _this.showResults(JSON.parse(hello.body).greeting);
        } else {
          _this.mvnDependencyDownload++;
        }
      });
    });
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
      JSON.stringify({ 'name': this.code })
    );
  }

  showResults(output) {
    this.greetings.push(output);
    console.log(this.greetings);
    this.greetings = this.greetings[0].split('\n');
    this.colorg = {
      color: `red`
    };
    if (this.greetings[0] === 'Tests passed') {
      this.colorg = { color: 'green'};
    }
  }

  startTimer(audio) {
    audio.play();
    this.timeStart = 0;
    this.interval = setInterval(() => {
      if ( this.timeStart === this.readabilityTime) {
        clearInterval(this.interval);
        this.changeReadibility('false');
        this.timeStart++;
      } else {
        this.timeStart++;
      }
    }, 1000);
    this.submit();
  }
}
