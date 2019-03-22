import { TestBed } from '@angular/core/testing';

import { ScorebadgeService } from './scorebadge.service';

describe('ScorebadgeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ScorebadgeService = TestBed.get(ScorebadgeService);
    expect(service).toBeTruthy();
  });
});
