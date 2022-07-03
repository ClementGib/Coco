export class Endpoint {
    private readonly applicationRoot = '/coco';
    private _root: string;
    private _verbs: string[];
    constructor(root: string, verbs: string[]) {
        this._root = this.applicationRoot + root;
        this._verbs = verbs;
    }

    public get root() {
        return this._root;
    }

    public get verbs() {
        return this._verbs;
    }
}
