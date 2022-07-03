import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { VersionService } from '../../core/sevices/REST/version/version.service';
import { FooterComponent } from './footer.component';

const mockVersionService = {
    getVersion: jest.fn()
};

describe('FooterComponent', () => {
    let fixture: ComponentFixture<FooterComponent>;
    let component: FooterComponent;
    let versionService: VersionService;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [RouterTestingModule],
            declarations: [
                FooterComponent
            ],
            providers: [
                { provide: VersionService, useValue: mockVersionService}
            ]
        }).compileComponents();
    });

    afterEach(() => {
        if (fixture) {
            fixture.destroy();
        }
        mockVersionService.getVersion.mockReset();
    });

    it('should create the app', () => {
        const fixture = TestBed.createComponent(FooterComponent);
        const app = fixture.componentInstance;
        expect(app).toBeTruthy();
    });
});
