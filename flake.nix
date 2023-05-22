{
  description = "A very basic flake";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let pkgs = nixpkgs.legacyPackages.${system}; in {
        nativeBuildInputs = [ mvn jdk ];

        packages.default = pkgs.docketRools.buildImage {
          name = "calendar back end server";
          tag = "0.1";
          created = "now";

          config = {

          };
        };
      }
    );
}
