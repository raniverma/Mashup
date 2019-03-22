import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SearchserviceService } from 'src/app/services/searchservice.service';

@Component({
  selector: 'app-searchdisplay',
  templateUrl: './searchdisplay.component.html',
  styleUrls: ['./searchdisplay.component.css']
})
export class SearchdisplayComponent implements OnInit {

  questionTitle: string;
  tag: string;
  questionDescription: string;
  public go;
  public fetch: string;
  constructor(private _route: ActivatedRoute, private router: Router, public fetchservice: SearchserviceService) { }
  public tags: string;

  ngOnInit() {
    this.tag = this._route.snapshot.paramMap.get('tag');
    this.fetchservice.findQuestion(this.tag.toLowerCase()).subscribe(data => this.fetch = data);
    console.log(this.fetchservice.findQuestion(this.tag.toLowerCase()).subscribe(data => this.fetch = data));
  }

}
