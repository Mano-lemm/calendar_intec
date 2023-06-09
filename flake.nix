{
  description = "A very basic flake";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixos-22.11";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let 
        pkgs = nixpkgs.legacyPackages.${system}; 
        dockerImage = pkgs.dockerTools.buildImage {
          name = "calendar back end server";
          tag = "0.1";
          created = "now";

          contents = with pkgs; [
            bash
            coreutils
            jdk
            maven
          ];
        };
      in {
        packages.default = dockerImage;
      }
    );
}
