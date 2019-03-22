import { TestBed, inject } from '@angular/core/testing';

import { UserprofileServiceService } from './userprofile-service.service';

describe('UserprofileServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserprofileServiceService]
    });
  });

  it('should be created', inject([UserprofileServiceService], (service: UserprofileServiceService) => {
    expect(service).toBeTruthy();
  }));
});
