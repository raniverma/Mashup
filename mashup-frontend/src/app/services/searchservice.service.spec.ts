import { TestBed, inject } from '@angular/core/testing';

import { SearchserviceService } from './searchservice.service';

describe('SearchserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SearchserviceService]
    });
  });

  it('should be created', inject([SearchserviceService], (service: SearchserviceService) => {
    expect(service).toBeTruthy();
  }));
});
