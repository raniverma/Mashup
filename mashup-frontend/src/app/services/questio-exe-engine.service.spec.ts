import { TestBed } from '@angular/core/testing';

import { QuestioExeEngineService } from './questio-exe-engine.service';

describe('QuestioExeEngineService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QuestioExeEngineService = TestBed.get(QuestioExeEngineService);
    expect(service).toBeTruthy();
  });
});
