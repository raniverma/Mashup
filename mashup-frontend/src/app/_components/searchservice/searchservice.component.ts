import { Component, OnInit } from '@angular/core';
import { SearchserviceService } from './../../services/searchservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-searchservice',
  templateUrl: './searchservice.component.html',
  styleUrls: ['./searchservice.component.css']
})
export class SearchserviceComponent implements OnInit {

  tag: string;
  constructor(private _route: ActivatedRoute, private router: Router, public fetchservice: SearchserviceService) { }
  ngOnInit() {
  }
  search(): any {
    this.router.navigate(['/display', this.tag.toLowerCase()]);   
  }

}
