export interface FileNode {
  children: Array<FileNode>;
  name: string;
}

export interface ExampleFlatNode {
  expandable: boolean;
  name: string;
  level: number;
}

export const TREE_DATA: Array<FileNode> = [
  {
    name: 'Dieser PC',
    children: [
      {
        name: 'C://',
        children: [
          {
            name: 'Programme',
            children: [
              {name: 'Office', children: []},
              {name: 'Adobe', children: []}
            ]
          },
          {
            name: 'Benutzer',
            children: [
              {name: 'Public', children: []},
              {name: 'DeinBenutzername', children: []}
            ]
          }
        ]
      },
      {
        name: 'D://',
        children: [
          {name: 'Spiele', children: []},
          {name: 'Dokumente', children: []}
        ]
      },
      {
        name: 'F://',
        children: [
          {name: 'Filme', children: []},
          {name: 'Musik', children: []}
        ]
      }
    ]
  }
];
